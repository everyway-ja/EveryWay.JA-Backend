package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.ItineraryCategory;
import everyway.everyway.repositories.ItineraryCategories_Repsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ItineraryCategories_Service {

    @Autowired private ItineraryCategories_Repsitory itineraryCategories_Repsitory;

    /**
     * Retrieves an itinerary category by its ID.
     * 
     * This method queries the repository to find a category with the specified ID.
     * 
     * @param id the ID of the itinerary category
     * @return the itinerary category with the specified ID, or null if not found
     */
    public ItineraryCategory findById ( int id ) {
        return itineraryCategories_Repsitory.findById(id);
    }

    /**
     * Retrieves a list of itinerary categories that match the given description.
     * 
     * This method queries the repository to find all categories with the specified description.
     * 
     * @param description the description to match against
     * @return a list of itinerary categories that match the description
     */
    public List<ItineraryCategory> findByDescription ( String description ) {
        return itineraryCategories_Repsitory.findByDescription(description);
    }

    /**
     * Retrieves a list of all itinerary categories.
     * 
     * This method queries the repository to return all the available itinerary categories.
     * 
     * @return a list of all itinerary categories
     */
    public List<ItineraryCategory> findAll () {
        return itineraryCategories_Repsitory.findAll();
    }
    
    // any other method for this specific object is useless: addition, deletion and update should be performed directly on the database
    
}