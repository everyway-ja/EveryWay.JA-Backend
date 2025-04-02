package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.Location_Itinerary_Account;
import everyway.everyway.repositories.Locations_Itineraries_Accounts_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class Locations_Itineraries_Accounts_Service {

    @Autowired private Locations_Itineraries_Accounts_Repository locations_Itineraries_Accounts_Repository;

    /**
     * Retrieves a location-itinerary-account association by location, itinerary, account, and creation timestamp.
     * 
     * This method queries the repository to find an association with the specified location, itinerary, account,
     * and creation timestamp.
     * 
     * @param location the location to search for
     * @param itinerary the itinerary to search for
     * @param account the account to search for
     * @param creation_timestamp the creation timestamp to search for
     * @return the location-itinerary-account association that matches the specified parameters, or null if not found
     */
    public Location_Itinerary_Account findByAssociatedLocationAndAssociatedItineraryAndAssociatedAccountAndCreationTimestamp ( Location location , Itinerary itinerary , Account account , LocalDateTime creation_timestamp ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedLocationAndAssociatedItineraryAndAssociatedAccountAndCreationTimestamp(location, itinerary, account, creation_timestamp);
    }

    /**
     * Retrieves a list of location-itinerary-account associations by location.
     * 
     * This method queries the repository to find associations with the specified location.
     * 
     * @param location the location to search for
     * @return a list of location-itinerary-account associations that match the specified location
     */
    public List<Location_Itinerary_Account> findByAssociatedLocation ( Location location ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedLocation(location);
    }

    /**
     * Retrieves a list of location-itinerary-account associations by itinerary.
     * 
     * This method queries the repository to find associations with the specified itinerary.
     * 
     * @param itinerary the itinerary to search for
     * @return a list of location-itinerary-account associations that match the specified itinerary
     */
    public List<Location_Itinerary_Account> findByAssociatedItinerary ( Itinerary itinerary ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedItinerary(itinerary);
    }

    /**
     * Retrieves a list of location-itinerary-account associations by account.
     * 
     * This method queries the repository to find associations with the specified account.
     * 
     * @param account the account to search for
     * @return a list of location-itinerary-account associations that match the specified account
     */
    public List<Location_Itinerary_Account> findByAssociatedAccount ( Account account ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedAccount(account);
    }

    /**
     * Retrieves a list of all location-itinerary-account associations.
     * 
     * This method queries the repository to return all available associations in the database.
     * 
     * @return a list of all location-itinerary-account associations
     */
    public List<Location_Itinerary_Account> findAll () {
        return locations_Itineraries_Accounts_Repository.findAll();
    }
    
}