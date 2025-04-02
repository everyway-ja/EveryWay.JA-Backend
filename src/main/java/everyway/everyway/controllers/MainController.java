package everyway.everyway.controllers;

import java.time.LocalDate;
import java.util.List;
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
import everyway.everyway.models.tables.Image;
import everyway.everyway.models.tables.Image_Itinerary;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.models.tables.ItineraryCategory;
import everyway.everyway.models.tables.ItineraryCategory_Itinerary;
import everyway.everyway.models.tables.Itinerary_Location;
import everyway.everyway.models.tables.Language;
import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.Location_Itinerary_Account;
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

        // check if username is already taken
        List<Account> existingAccount = accounts_Service.findByUsername(username);
        if ( !existingAccount.isEmpty() ) {
            return "redirect:/register?error=true";
        }

        // set up new account
        Account newAccount = new Account();
        newAccount.setName(name);
        newAccount.setSurname(surname);
        newAccount.setUsername(username);
        newAccount.setEmail(email);

        String encryptedPassword = utils.encryptString(password);
        newAccount.setPassword(encryptedPassword);
        
        newAccount.setBirthDate(birthDate);
        newAccount.setAssociatedLanguage(associatedLanguage);
        newAccount.setAssociatedImage(associatedImage);
        
        // link the new account with the selected account categories
        accounts_Service.addAccount(newAccount);
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

        // set up new itinerary
        Itinerary newItinerary = new Itinerary();
        newItinerary.setName(name);
        newItinerary.setDescription(description);
        newItinerary.setAssociatedAccount(associatedAccount);

        itineraries_Service.addItinerary(newItinerary);

        // link the images
        for ( Image image : associatedImages ) {
            images_Itineraries_Service.addAssociation( new Image_Itinerary(image, newItinerary) );
        }

        // link the locations
        for ( Location location : associatedLocations ) {
            itineraries_Locations_Service.addAssociation( new Itinerary_Location(newItinerary, location, associatedLocations.indexOf(location)) );
        }

        // link the account categorie
        for ( AccountCategory accountCategory : associatedAccountCategories ) {
            accountCategories_Itineraries_Service.addAssociation( new AccountCategory_Itinerary(accountCategory, newItinerary) );
        }

        // link the itinerary categories
        for ( ItineraryCategory itineraryCategory : associatedItineraryCategories ) {
            itineraryCategories_Itineraries_Service.addAssociation( new ItineraryCategory_Itinerary(itineraryCategory, newItinerary) );
        }

        return "redirect:/home";

    }
    
}
