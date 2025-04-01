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

    public Location_Itinerary_Account findByAssociatedLocationAndAssociatedItineraryAndAssociatedAccountAndCreationTimestamp ( Location location , Itinerary itinerary , Account account , LocalDateTime creation_timestamp ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedLocationAndAssociatedItineraryAndAssociatedAccountAndCreationTimestamp(location, itinerary, account, creation_timestamp);
    }

    public List<Location_Itinerary_Account> findByAssociatedLocation ( Location location ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedLocation(location);
    }

    public List<Location_Itinerary_Account> findByAssociatedItinerary ( Itinerary itinerary ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedItinerary(itinerary);
    }

    public List<Location_Itinerary_Account> findByAssociatedAccount ( Account account ) {
        return locations_Itineraries_Accounts_Repository.findByAssociatedAccount(account);
    }

    public List<Location_Itinerary_Account> findAll () {
        return locations_Itineraries_Accounts_Repository.findAll();
    }
    
}