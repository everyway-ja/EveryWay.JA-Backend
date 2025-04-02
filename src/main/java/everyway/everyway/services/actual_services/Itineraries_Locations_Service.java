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
     * Finds an Itinerary_Location by its associated Itinerary and Location.
     *
     * @param itinerary the associated Itinerary
     * @param location the associated Location
     * @return the Itinerary_Location that matches the given Itinerary and Location
     */
    public Itinerary_Location findByAssociatedItineraryAndAssociatedLocation ( Itinerary itinerary , Location location ) {
        return itineraries_Locations_Repository.findByAssociatedItineraryAndAssociatedLocation(itinerary, location);
    }

    /**
     * Finds Itinerary_Location entities by their associated Itinerary.
     *
     * @param itinerary the associated Itinerary
     * @return a list of Itinerary_Location entities associated with the given Itinerary
     */
    public List<Itinerary> findByAssociatedItinerary ( Itinerary itinerary ) {
        return itineraries_Locations_Repository.findByAssociatedItinerary(itinerary);
    }

    /**
     * Finds Itinerary_Location entities by their associated Location.
     *
     * @param location the associated Location
     * @return a list of Itinerary_Location entities associated with the given Location
     */
    public List<Location> findByAssociatedLocation ( Location location ) {
        return itineraries_Locations_Repository.findByAssociatedLocation(location);
    }

    /**
     * Finds all Itinerary_Location entities.
     *
     * @return a list of all Itinerary_Location entities
     */
    public List<Itinerary_Location> findAll () {
        return itineraries_Locations_Repository.findAll();
    }



    // add a new association between itinerary and location
    public Itinerary_Location addAssociation ( Itinerary_Location itinerary_location ) {
        return itineraries_Locations_Repository.save(itinerary_location);
    }
    
}