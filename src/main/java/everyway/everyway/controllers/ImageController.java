package everyway.everyway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import org.apache.commons.io.FilenameUtils;
import everyway.everyway.models.Utils;
import everyway.everyway.services.actual_services.*;

// TODO : THE UPLOAD AND DOWNLOAD METHODS ARE NOT SECURE, ADD SECURITY CHECKS, VALIDATION, EXCEPTION HANDLING AND DISTINCTIONS FOR DIFFERENT TYPES OF IMAGES UPLOADS AND DOWNLAODS (profile pictures, itinerary pictures, etc.)

@Controller

public class ImageController {

    @Autowired private Utils utils;
    @Value("${file.upload.path}")  private String uploadPath;

    @PostMapping("/upload")
    public ResponseEntity<String> handle_fileUpload ( @RequestParam("file") MultipartFile file ) {
        
        if (file.isEmpty()) {
            return new ResponseEntity<>("Missing File.", HttpStatus.BAD_REQUEST);
        }

        try {
        
            utils.save_file(file, uploadPath);
            // TODO : generate image description

            return new ResponseEntity<>("Success.", HttpStatus.OK);
        
        } 
        
        catch ( IOException e ) {
            e.printStackTrace();
            return new ResponseEntity<>("Error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/uploadMultiple")
    public ResponseEntity<String> handle_multipleFileUpload ( @RequestParam("files") MultipartFile[] files ) {
        
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                return new ResponseEntity<>("Missing files.", HttpStatus.BAD_REQUEST);
            }
        }

        try {
    
            for ( MultipartFile file : files ) {
    
                utils.save_file(file, uploadPath);
                // TODO : generate images' description
    
            }
    
            return new ResponseEntity<>("Success.", HttpStatus.OK);
    
        } 
        
        catch ( IOException e ) {
            e.printStackTrace();
            return new ResponseEntity<>("Error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download_file ( @RequestParam("filename") String filename ) {
    
        try {
    
            byte[] file = utils.read_file(filename, uploadPath);
    
            ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok();
            responseBuilder.header("Content-Disposition", "attachment; filename=" + filename);
            return responseBuilder.body(file);
    
        } 
        
        catch ( IOException e ) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @GetMapping("/downloadMultiple")
    public ResponseEntity<byte[]> download_multipleFiles ( @RequestParam("filenames") String[] filenames ) {
        
        try {
        
            byte[] combinedFiles = utils.combine_files(filenames, uploadPath);
        
            ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok();
            responseBuilder.header("Content-Disposition", "attachment; filename=files.zip");
            return responseBuilder.body(combinedFiles);
        
        } 
        
        catch ( IOException e ) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }
}