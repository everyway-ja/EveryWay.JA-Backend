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

    public Itinerary_Location findByAssociatedItineraryAndAssociatedLocation ( Itinerary itinerary , Location location ) {
        return itineraries_Locations_Repository.findByAssociatedItineraryAndAssociatedLocation(itinerary, location);
    }

    public List<Itinerary> findByAssociatedItinerary ( Itinerary itinerary ) {
        return itineraries_Locations_Repository.findByAssociatedItinerary(itinerary);
    }

    public List<Location> findByAssociatedLocation ( Location location ) {
        return itineraries_Locations_Repository.findByAssociatedLocation(location);
    }

    public List<Itinerary_Location> findAll () {
        return itineraries_Locations_Repository.findAll();
    }



    // add a new association between itinerary and location
    public Itinerary_Location addAssociation ( Itinerary_Location itinerary_location ) {
        return itineraries_Locations_Repository.save(itinerary_location);
    }
    
}