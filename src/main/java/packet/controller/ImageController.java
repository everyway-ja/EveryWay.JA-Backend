package packet.controller;

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

@Controller
public class ImageController {

    @Value("${file.upload.path}") private String uploadPath;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload( @RequestParam("file") MultipartFile file ) {
        
        if (file.isEmpty()) {
            return new ResponseEntity<>("Missing File.", HttpStatus.BAD_REQUEST);
        }

        try {

            Path path = Paths.get(uploadPath, file.getOriginalFilename());
            Files.createDirectories(path.getParent()); // Crea le directory se non esistono
            Files.write(path, file.getBytes());

            // TODO : generate image description

            return new ResponseEntity<>("Success.", HttpStatus.OK);

        } 
        
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @PostMapping("/uploadMultiple")
    public ResponseEntity<String> handleMultipleFileUpload( @RequestParam("files") MultipartFile[] files ) {
        
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                return new ResponseEntity<>("Missing files.", HttpStatus.BAD_REQUEST);
            }
        }

        try {

            for (MultipartFile file : files) {
                Path path = Paths.get(uploadPath, file.getOriginalFilename());
                Files.createDirectories(path.getParent()); // Crea le directory se non esistono
                Files.write(path, file.getBytes());

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
    public ResponseEntity<byte[]> downloadFile( @RequestParam("filename") String filename ) {
        
        try {

            Path path = Paths.get(uploadPath, filename);
            byte[] file = Files.readAllBytes(path);

            return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=" + filename).body(file);

        } 
        
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @GetMapping("/downloadMultiple")
    public ResponseEntity<byte[]> downloadMultipleFiles( @RequestParam("filenames") String[] filenames ) {
        
        try {

            Path path = Paths.get(uploadPath, filenames[0]);
            byte[] file = Files.readAllBytes(path);

            for (int i = 1; i < filenames.length; i++) {
                path = Paths.get(uploadPath, filenames[i]);
                byte[] temp = Files.readAllBytes(path);
                byte[] result = new byte[file.length + temp.length];
                System.arraycopy(file, 0, result, 0, file.length);
                System.arraycopy(temp, 0, result, file.length, temp.length);
                file = result;
            }

            return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=files.zip").body(file);

        } 
        
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

}