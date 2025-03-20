package everyway.everyway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller

public class MainController {

    // TOCHECK DA RIMUOVERE A TEMPO DEBITO
    @RequestMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok().body("{'message': 'Backend funzionante'}");
    }

    @GetMapping("/error")
    public String error ( Model model , @RequestParam( value="error" , required=false ) String error ) {
        model.addAttribute("error", error);
        return "error";
    }

}