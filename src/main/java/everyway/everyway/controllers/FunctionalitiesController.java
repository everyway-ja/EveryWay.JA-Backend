package everyway.everyway.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import everyway.everyway.services.actual_services.*;
import everyway.everyway.models.tables.*;
import java.time.LocalDate;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller

public class FunctionalitiesController {

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
    


    private String encryptPassword ( String password ) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password", e);
        }
    }
    
    // login
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

        // encrypt password and compare with the one in the database
        String encryptedPassword = encryptPassword(password);

        Account loggedAccount = accounts_Service.findByIdAndPassword(pickedAccount.getId(), encryptedPassword);
        if ( loggedAccount != null ) {
            session.setAttribute("loggedAccount", loggedAccount);
            return "redirect:/home";
        } 
        else {
            return "redirect:/login?error=true";
        }

    }

    // register
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
        @RequestParam List<AccountCategory> associatedAccountCategory ,
        HttpSession session 
    ) {

        Account newAccount = new Account();
        newAccount.setName(name);
        newAccount.setSurname(surname);
        newAccount.setUsername(username);
        newAccount.setEmail(email);

        String encryptedPassword = encryptPassword(password);
        newAccount.setPassword(encryptedPassword);
        
        newAccount.setBirthDate(birthDate);
        newAccount.setAssociatedLanguage(associatedLanguage);
        newAccount.setAssociatedImage(associatedImage);
        

        accounts_Service.addAccount(newAccount);
        for ( AccountCategory accountCategory : associatedAccountCategory ) {
            accountCategories_Accounts_Service.addAssociation( new AccountCategory_Account(accountCategory, newAccount) );
        }
        session.setAttribute("loggedAccount", newAccount);
        
        return "redirect:/home";

    }

    @GetMapping("/logout")
    public String logout ( HttpSession session ) {
        session.invalidate();
        return "redirect:/login";
    }

}
