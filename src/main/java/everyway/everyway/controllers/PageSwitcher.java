package everyway.everyway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import everyway.everyway.services.actual_services.*;

@Controller

public class PageSwitcher {

    private final AccountCategories_Accounts_Service accountCategories_Accounts_Service = new AccountCategories_Accounts_Service();
    private final AccountCategories_Itineraries_Service accountCategories_Itineraries_Service = new AccountCategories_Itineraries_Service();
    private final AccountCategories_LocationReports_Service accountCategories_LocationReports_Service = new AccountCategories_LocationReports_Service();
    private final AccountCategories_Locations_Service accountCategories_Locations_Service = new AccountCategories_Locations_Service();
    private final AccountCategories_Service accountCategories_Service = new AccountCategories_Service();
    private final Accounts_Positions_Service accounts_Positions_Service = new Accounts_Positions_Service();
    private final Accounts_Service accounts_Service = new Accounts_Service();
    private final Images_Service images_Service = new Images_Service();
    private final Images_Itineraries_Service images_Itineraries_Service = new Images_Itineraries_Service();
    private final Images_Locations_Service images_Locations_Service = new Images_Locations_Service();
    private final Itineraries_Service itineraries_Service = new Itineraries_Service();
    private final ItineraryCategories_Service itineraryCategories_Service = new ItineraryCategories_Service();
    private final ItineraryCategories_Itineraries_Service itineraryCategories_Itineraries_Service = new ItineraryCategories_Itineraries_Service();
    private final Languages_Service languages_Service = new Languages_Service();
    private final LocationCategories_Service locationCategories_Service = new LocationCategories_Service();
    private final LocationCategories_LocationReports_Service locationCategories_LocationReports_Service = new LocationCategories_LocationReports_Service();
    private final LocationCategories_Locations_Service locationCategories_Locations_Service = new LocationCategories_Locations_Service();
    private final LocationReports_Service locationReports_Service = new LocationReports_Service();
    private final Locations_Service locations_Service = new Locations_Service();
    private final Locations_Itineraries_Accounts_Service locations_Itineraries_Accounts_Service = new Locations_Itineraries_Accounts_Service();
    private final Positions_Service positions_Service = new Positions_Service();
    private final Reviews_Service reviews_Service = new Reviews_Service();

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