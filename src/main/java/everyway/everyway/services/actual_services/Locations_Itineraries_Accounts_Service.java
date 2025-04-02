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
     * @param location The Location object to filter by.
     * @param itinerary The Itinerary object to filter by.
     * @param account The Account object to filter by.
     * @param creation_timestamp The creation timestamp to filter by.
     * @return Location_Itinerary_Account - The matching association, or null if not found.
     */
    public Location_Itinerary_Account findByAssociatedLocationAndAssociatedItineraryAndAssociatedAccountAndCreationTimestamp ( Location location , Itinerary itinerary , Account account , LocalDateTime creation_timestamp ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedLocationAndAssociatedItineraryAndAssociatedAccountAndCreationTimestamp(location, itinerary, account, creation_timestamp);
    }

    /**
     * Retrieves a list of location-itinerary-account associations by location.
     *
     * @param location The Location object to filter by.
     * @return List<Location_Itinerary_Account> - A list of associations matching the specified location.
     */
    public List<Location_Itinerary_Account> findByAssociatedLocation ( Location location ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedLocation(location);
    }

    /**
     * Retrieves a list of location-itinerary-account associations by itinerary.
     *
     * @param itinerary The Itinerary object to filter by.
     * @return List<Location_Itinerary_Account> - A list of associations matching the specified itinerary.
     */
    public List<Location_Itinerary_Account> findByAssociatedItinerary ( Itinerary itinerary ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedItinerary(itinerary);
    }

    /**
     * Retrieves a list of location-itinerary-account associations by account.
     *
     * @param account The Account object to filter by.
     * @return List<Location_Itinerary_Account> - A list of associations matching the specified account.
     */
    public List<Location_Itinerary_Account> findByAssociatedAccount ( Account account ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedAccount(account);
    }

    /**
     * Retrieves all location-itinerary-account associations.
     *
     * @return List<Location_Itinerary_Account> - A list of all associations in the database.
     */
    public List<Location_Itinerary_Account> findAll () {
        return locations_Itineraries_Accounts_Repository.findAll();
    }
    
}