package everyway.everyway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {

    // TOCHECK DA RIMUOVERE A TEMPO DEBITO
    @RequestMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok().body("{'message': 'Backend funzionante'}");
    }

}