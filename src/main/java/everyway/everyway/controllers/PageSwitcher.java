package everyway.everyway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import everyway.everyway.services.actual_services.*;

@Controller

public class PageSwitcher {

    // TOCHECK DA RIMUOVERE A TEMPO DEBITO
    @GetMapping("/")
    public ResponseEntity<String> index () {
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok();
        ResponseEntity<String> response = responseBuilder.body("{'message': 'Backend funzionante'}");
        return response;
    }

    @GetMapping("/error")
    public String error ( Model model , @RequestParam( value="error" , required=false ) String error ) {
        model.addAttribute("error", error);
        return "error";
    }

}