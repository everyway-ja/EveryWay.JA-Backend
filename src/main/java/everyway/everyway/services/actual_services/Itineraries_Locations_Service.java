package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.models.tables.Itinerary_Location;
import everyway.everyway.models.tables.Location;
import everyway.everyway.repositories.Itineraries_Locations_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Itineraries_Locations_Service {

    @Autowired private Itineraries_Locations_Repository itineraries_Locations_Repository;

    /**
     * Finds an Itinerary_Location association by the associated itinerary and location.
     *
     * @param itinerary The Itinerary object to filter by.
     * @param location The Location object to filter by.
     * @return Itinerary_Location - The association matching the given itinerary and location, or null if no match is found.
     */
    public Itinerary_Location findByAssociatedItineraryAndAssociatedLocation ( Itinerary itinerary , Location location ) {
        return itineraries_Locations_Repository.findByAssociatedItineraryAndAssociatedLocation(itinerary, location);
    }

    /**
     * Retrieves all Itinerary_Location associations for a specific itinerary.
     *
     * @param itinerary The Itinerary object to filter by.
     * @return List<Itinerary> - A list of Itinerary_Location associations linked to the specified itinerary.
     */
    public List<Itinerary> findByAssociatedItinerary ( Itinerary itinerary ) {
        return itineraries_Locations_Repository.findByAssociatedItinerary(itinerary);
    }

    /**
     * Retrieves all Itinerary_Location associations for a specific location.
     *
     * @param location The Location object to filter by.
     * @return List<Location> - A list of Itinerary_Location associations linked to the specified location.
     */
    public List<Location> findByAssociatedLocation ( Location location ) {
        return itineraries_Locations_Repository.findByAssociatedLocation(location);
    }

    /**
     * Retrieves all Itinerary_Location associations stored in the database.
     *
     * @return List<Itinerary_Location> - A list of all Itinerary_Location associations.
     */
    public List<Itinerary_Location> findAll () {
        return itineraries_Locations_Repository.findAll();
    }

    // add a new association between itinerary and location
    public Itinerary_Location addAssociation ( Itinerary_Location itinerary_location ) {
        return itineraries_Locations_Repository.save(itinerary_location);
    }
    
}