package packet.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    @Value("${file.upload.path}")
    private String uploadPath;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Seleziona un file!", HttpStatus.BAD_REQUEST);
        }

        try {
            Path path = Paths.get(uploadPath, file.getOriginalFilename()); // Corretto: senza +
            Files.createDirectories(path.getParent()); // Crea le directory se non esistono
            Files.write(path, file.getBytes());

            return new ResponseEntity<>("File caricato con successo!", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Errore durante il caricamento del file!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}