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
import org.springframework.beans.factory.annotation.Autowired;

@Controller

public class FunctionalitiesController {

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
