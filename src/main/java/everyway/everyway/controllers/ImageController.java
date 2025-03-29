package everyway.everyway.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FilenameUtils;

// TODO : THE UPLOAD AND DOWNLOAD METHODS ARE NOT SECURE, ADD SECURITY CHECKS, VALIDATION, EXCEPTION HANDLING AND DISTINCTIONS FOR DIFFERENT TYPES OF IMAGES UPLOADS AND DOWNLAODS (profile pictures, itinerary pictures, etc.)

@Controller
public class ImageController {

    @Value("${file.upload.path}") 
    private String uploadPath;

    @PostMapping("/upload")
    public ResponseEntity<String> handle_fileUpload ( @RequestParam("file") MultipartFile file ) {
        
        if (file.isEmpty()) {
            return new ResponseEntity<>("Missing File.", HttpStatus.BAD_REQUEST);
        }

        try {
        
            save_file(file);
            // TODO : generate image description

            return new ResponseEntity<>("Success.", HttpStatus.OK);
        
        } 
        
        catch (IOException e) {
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
    
            for (MultipartFile file : files) {
    
                save_file(file);
                // TODO : generate images' description
    
            }
    
            return new ResponseEntity<>("Success.", HttpStatus.OK);
    
        } 
        
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download_file ( @RequestParam("filename") String filename ) {
    
        try {
    
            byte[] file = read_file(filename);
    
            ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok();
            responseBuilder.header("Content-Disposition", "attachment; filename=" + filename);
            return responseBuilder.body(file);
    
        } 
        
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @GetMapping("/downloadMultiple")
    public ResponseEntity<byte[]> download_multipleFiles ( @RequestParam("filenames") String[] filenames ) {
        
        try {
        
            byte[] combinedFiles = combine_files(filenames);
        
            ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok();
            responseBuilder.header("Content-Disposition", "attachment; filename=files.zip");
            return responseBuilder.body(combinedFiles);
        
        } 
        
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }


    
    private void save_file ( MultipartFile file ) throws IOException {
        
        Path path = get_filePath(file.getOriginalFilename());
        createDirectoriesIfNotExist(path.getParent());
        Files.write(path, file.getBytes());
    
    }

    private void createDirectoriesIfNotExist(Path directory) throws IOException {
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
    }

    private byte[] read_file ( String filename ) throws IOException {
        
        Path path = get_filePath(filename);

        return Files.readAllBytes(path);
    
    }

    private byte[] combine_files ( String[] filenames ) throws IOException {

        int totalLength = 0;
        byte[][] fileContents = new byte[filenames.length][];

        for (int i = 0; i < filenames.length; i++) {
            fileContents[i] = read_file(filenames[i]);
            totalLength += fileContents[i].length;
        }

        byte[] combined = new byte[totalLength];
        int currentPosition = 0;

        for (byte[] fileContent : fileContents) {
            System.arraycopy(fileContent, 0, combined, currentPosition, fileContent.length);
            currentPosition += fileContent.length;
        }

        return combined;

    }

    private Path get_filePath ( String filename ) {
        String sanitizedFilename = FilenameUtils.getName(filename);
        return Paths.get(uploadPath, sanitizedFilename);
    }

}