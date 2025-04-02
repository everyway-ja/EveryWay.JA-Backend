package everyway.everyway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import everyway.everyway.services.actual_services.*;

@Controller

public class PageSwitcher {

    @Autowired private AccountCategories_Accounts_Service accountCategories_Accounts_Service;
    @Autowired private AccountCategories_Itineraries_Service accountCategories_Itineraries_Service;
    @Autowired private AccountCategories_LocationReports_Service accountCategories_LocationReports_Service;
    @Autowired private AccountCategories_Locations_Service accountCategories_Locations_Service;
    @Autowired private AccountCategories_Service accountCategories_Service;
    @Autowired private Accounts_Positions_Service accounts_Positions_Service;
    @Autowired private Accounts_Service accounts_Service;
    @Autowired private Images_Service images_Service;
    @Autowired private Images_Itineraries_Service images_Itineraries_Service;
    @Autowired private Images_Locations_Service images_Locations_Service;
    @Autowired private Itineraries_Service itineraries_Service;
    @Autowired private ItineraryCategories_Service itineraryCategories_Service;
    @Autowired private ItineraryCategories_Itineraries_Service itineraryCategories_Itineraries_Service;
    @Autowired private Languages_Service languages_Service;
    @Autowired private LocationCategories_Service locationCategories_Service;
    @Autowired private LocationCategories_LocationReports_Service locationCategories_LocationReports_Service;
    @Autowired private LocationCategories_Locations_Service locationCategories_Locations_Service;
    @Autowired private LocationReports_Service locationReports_Service;
    @Autowired private Locations_Service locations_Service;
    @Autowired private Locations_Itineraries_Accounts_Service locations_Itineraries_Accounts_Service;
    @Autowired private Positions_Service positions_Service;
    @Autowired private Reviews_Service reviews_Service;

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