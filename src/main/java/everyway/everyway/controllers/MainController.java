package everyway.everyway.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import everyway.everyway.models.Utils;
import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.AccountCategory_Account;
import everyway.everyway.models.tables.AccountCategory_Itinerary;
import everyway.everyway.models.tables.AccountCategory_Location;
import everyway.everyway.models.tables.Image;
import everyway.everyway.models.tables.Image_Itinerary;
import everyway.everyway.models.tables.Image_Location;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.models.tables.ItineraryCategory;
import everyway.everyway.models.tables.ItineraryCategory_Itinerary;
import everyway.everyway.models.tables.Itinerary_Location;
import everyway.everyway.models.tables.Language;
import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.LocationCategory;
import everyway.everyway.models.tables.LocationCategory_Location;
import everyway.everyway.models.tables.Location_Itinerary_Account;
import everyway.everyway.models.tables.Position;
import everyway.everyway.services.actual_services.AccountCategories_Accounts_Service;
import everyway.everyway.services.actual_services.AccountCategories_Itineraries_Service;
import everyway.everyway.services.actual_services.AccountCategories_LocationReports_Service;
import everyway.everyway.services.actual_services.AccountCategories_Locations_Service;
import everyway.everyway.services.actual_services.AccountCategories_Service;
import everyway.everyway.services.actual_services.Accounts_Positions_Service;
import everyway.everyway.services.actual_services.Accounts_Service;
import everyway.everyway.services.actual_services.Images_Itineraries_Service;
import everyway.everyway.services.actual_services.Images_Locations_Service;
import everyway.everyway.services.actual_services.Images_Service;
import everyway.everyway.services.actual_services.Itineraries_Locations_Service;
import everyway.everyway.services.actual_services.Itineraries_Service;
import everyway.everyway.services.actual_services.ItineraryCategories_Itineraries_Service;
import everyway.everyway.services.actual_services.ItineraryCategories_Service;
import everyway.everyway.services.actual_services.Languages_Service;
import everyway.everyway.services.actual_services.LocationCategories_LocationReports_Service;
import everyway.everyway.services.actual_services.LocationCategories_Locations_Service;
import everyway.everyway.services.actual_services.LocationCategories_Service;
import everyway.everyway.services.actual_services.LocationReports_Service;
import everyway.everyway.services.actual_services.Locations_Itineraries_Accounts_Service;
import everyway.everyway.services.actual_services.Locations_Service;
import everyway.everyway.services.actual_services.Positions_Service;
import everyway.everyway.services.actual_services.Reviews_Service;
import jakarta.servlet.http.HttpSession;

@Controller

public class MainController {
    
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
    @Autowired private Itineraries_Locations_Service itineraries_Locations_Service;
    @Autowired private Languages_Service languages_Service;
    @Autowired private LocationCategories_Service locationCategories_Service;
    @Autowired private LocationCategories_LocationReports_Service locationCategories_LocationReports_Service;
    @Autowired private LocationCategories_Locations_Service locationCategories_Locations_Service;
    @Autowired private LocationReports_Service locationReports_Service;
    @Autowired private Locations_Service locations_Service;
    @Autowired private Locations_Itineraries_Accounts_Service locations_Itineraries_Accounts_Service;
    @Autowired private Positions_Service positions_Service;
    @Autowired private Reviews_Service reviews_Service;
    
    @Autowired private Utils utils;



    //! METHODS THAT THE FRONTEND MUST IMPLEMENT



    //! METHODS THAT THE BACKEND MUST IMPLEMENT
    @PostMapping("/login")
    public String login ( 
        @RequestParam String username , 
        @RequestParam String password , 
        HttpSession session 
    ) {

        List<Account> account = accounts_Service.findByUsername(username);
        Account pickedAccount = account.get(0);

        if ( pickedAccount == null ) {
            return "redirect:/login?error=true";
        }
        if ( pickedAccount.getDeletion_timestamp() != null ) {
            return "redirect:/login?error=true";
        }

        String encryptedPassword = utils.encryptString(password);

        Account loggedAccount = accounts_Service.findByIdAndPassword(pickedAccount.getId(), encryptedPassword);
        if ( loggedAccount != null ) {
            session.setAttribute("loggedAccount", loggedAccount);
            return "redirect:/home";
        } 
        else {
            return "redirect:/login?error=true";
        }

    }

    @PostMapping("/register")
    public String register ( 
        @RequestParam String name , 
        @RequestParam String surname , 
        @RequestParam String username , 
        @RequestParam String email , 
        @RequestParam String password , 
        @RequestParam LocalDate birthDate , 
        @RequestParam Language associatedLanguage ,
        @RequestParam Image associatedImage ,
        @RequestParam List<AccountCategory> associatedAccountCategories ,
        HttpSession session 
    ) {
        
        Account newAccount = new Account();
        
        // the username musn't be null and must be unique
        List<Account> existingAccount = accounts_Service.findByUsername(username);
        if ( !existingAccount.isEmpty() ) {
            return "redirect:/register?error=true";
        }
        newAccount.setUsername(username);
        
        // name, surname and email mustn't be empty
        if (name.strip().isEmpty() || surname.strip().isEmpty() || email.strip().isEmpty()) {
            return "redirect:/register?error=true";
        }
        newAccount.setName(name);
        newAccount.setSurname(surname);
        newAccount.setEmail(email);

        // password mustn't be empty and at least 12 characters long
        if (password.strip().isEmpty() || password.length() < 12) {
            return "redirect:/register?error=true";
        }
        String encryptedPassword = utils.encryptString(password);
        newAccount.setPassword(encryptedPassword);

        // check that the birthdate is at least 14 years ago
        LocalDate today = LocalDate.now();
        LocalDate minBirthDate = today.minusYears(14);
        if (birthDate.isAfter(minBirthDate)) {
            return "redirect:/register?error=true";
        }
        newAccount.setBirthDate(birthDate);
        
        // associated language mustn't be null
        if (associatedLanguage == null) {
            return "redirect:/register?error=true";
        }
        newAccount.setAssociatedLanguage(associatedLanguage);
        
        // associated image mustn't be null
        if (associatedImage == null) {
            return "redirect:/register?error=true";
        }
        newAccount.setAssociatedImage(associatedImage);
        
        // create account
        accounts_Service.addAccount(newAccount);
        
        // associate the account with categories
        for ( AccountCategory accountCategory : associatedAccountCategories ) {
            accountCategories_Accounts_Service.addAssociation( new AccountCategory_Account(accountCategory, newAccount) );
        }

        session.setAttribute("loggedAccount", newAccount);
        
        return "redirect:/home";

    }

    @PostMapping("/upload")
    public ResponseEntity<String> handle_fileUpload ( @RequestParam("file") MultipartFile file ) {
        
        if (file.isEmpty()) {
            return new ResponseEntity<>("Missing File.", HttpStatus.BAD_REQUEST);
        }

        try {
        
            utils.save_file(file);
            Image image = new Image();
            image.setImagePath(file.getOriginalFilename());
            images_Service.addImage(image);
            // TODO : generate image's description

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
    
                utils.save_file(file);
                Image image = new Image();
                image.setImagePath(file.getOriginalFilename());
                images_Service.addImage(image);
                // TODO : generate images' description
    
            }
    
            return new ResponseEntity<>("Success.", HttpStatus.OK);
    
        } 
        
        catch ( IOException e ) {
            e.printStackTrace();
            return new ResponseEntity<>("Error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @PostMapping("/addItinerary")
    public String add_itinerary (
        @RequestParam String name , 
        @RequestParam String description , 
        @RequestParam Account associatedAccount ,
        @RequestParam List<Image> associatedImages, 
        @RequestParam List<Location> associatedLocations , 
        @RequestParam List<AccountCategory> associatedAccountCategories , 
        @RequestParam List<ItineraryCategory> associatedItineraryCategories , 
        HttpSession session 
    ) {

        Itinerary newItinerary = new Itinerary();

        // the name and description mustn't be empty
        if (name.strip().isEmpty() || description.strip().isEmpty()) {
            return "redirect:/addItinerary?error=true";
        }
        newItinerary.setName(name);
        newItinerary.setDescription(description);
        
        // the associated account must be the one that is logged in
        Account loggedAccount = (Account) session.getAttribute("loggedAccount");
        if (loggedAccount == null || !loggedAccount.equals(associatedAccount)) {
            return "redirect:/addItinerary?error=true";
        }
        newItinerary.setAssociatedAccount(associatedAccount);

        // create itinerary
        itineraries_Service.addItinerary(newItinerary);

        // associate the itinerary with images, locations, account categories and itinerary categories
        for ( Image image : associatedImages ) {
            images_Itineraries_Service.addAssociation( new Image_Itinerary(image, newItinerary) );
        }

        for ( Location location : associatedLocations ) {
            itineraries_Locations_Service.addAssociation( new Itinerary_Location(newItinerary, location, associatedLocations.indexOf(location)) );
        }

        for ( AccountCategory accountCategory : associatedAccountCategories ) {
            accountCategories_Itineraries_Service.addAssociation( new AccountCategory_Itinerary(accountCategory, newItinerary) );
        }

        for ( ItineraryCategory itineraryCategory : associatedItineraryCategories ) {
            itineraryCategories_Itineraries_Service.addAssociation( new ItineraryCategory_Itinerary(itineraryCategory, newItinerary) );
        }

        return "redirect:/home";

    }

    @PostMapping("/addLocation")
    public String add_location (
        @RequestParam String name , 
        @RequestParam String description , 
        @RequestParam Account associatedAccount , 
        @RequestParam Position associatedPosition , 
        @RequestParam List<Image> associatedImages , 
        @RequestParam List<AccountCategory> associatedAccountCategories , 
        @RequestParam List<LocationCategory> associatedLocationCategories , 
        HttpSession session 
    ) {

        Location newLocation = new Location();

        // the name and description mustn't be empty
        if (name.strip().isEmpty() || description.strip().isEmpty()) {
            return "redirect:/addLocation?error=true";
        }
        newLocation.setName(name);
        newLocation.setDescription(description);
        
        // the associated account must be the one that is logged in
        Account loggedAccount = (Account) session.getAttribute("loggedAccount");
        if (loggedAccount == null || !loggedAccount.equals(associatedAccount)) {
            return "redirect:/addLocation?error=true";
        }
        newLocation.setAssociatedAccount(associatedAccount);
        
        // the associated position mustn't be null
        if (associatedPosition == null) {
            return "redirect:/addLocation?error=true";
        }
        newLocation.setAssociatedPosition(associatedPosition);

        // create location
        locations_Service.addLocation(newLocation);

        // associate the location with images, account categories and location categories
        for ( Image image : associatedImages ) {
            images_Locations_Service.addAssociation( new Image_Location(image, newLocation) );
        }

        for ( AccountCategory accountCategory : associatedAccountCategories ) {
            accountCategories_Locations_Service.addAssociation( new AccountCategory_Location(accountCategory, newLocation) );
        }

        for ( LocationCategory locationCategory : associatedLocationCategories ) {
            locationCategories_Locations_Service.addAssociation( new LocationCategory_Location(locationCategory, newLocation) );
        }

        return "redirect:/home";

    }

    @PostMapping("/sendEmail")
    public ResponseEntity<Map<String, String>> send_email ( @RequestParam String name , @RequestParam String email , @RequestParam String message ) {
        
        Map<String, String> response = new HashMap<>();

        if (name.strip().isEmpty() || email.strip().isEmpty() || message.strip().isEmpty()) {
            response.put("error", "Nome, email o messaggio non possono essere vuoti.");
            return ResponseEntity.badRequest().body(response);
        }

        try {

            utils.sendEmail(name, email, message);
            response.put("message", "Email inviata con successo.");
            return ResponseEntity.ok(response);
        
        } 
        
        catch ( Exception e ) {
            response.put("error", e.toString());
            return ResponseEntity.badRequest().body(response);
        }
    
    }
    
}
