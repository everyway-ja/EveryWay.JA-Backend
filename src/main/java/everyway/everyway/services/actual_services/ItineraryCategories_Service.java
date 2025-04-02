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
     * Retrieves an itinerary category by its unique identifier.
     *
     * @param id The unique identifier of the itinerary category.
     * @return ItineraryCategory - The ItineraryCategory object matching the given ID, or null if no match is found.
     */
    public ItineraryCategory findById ( int id ) {
        return itineraryCategories_Repsitory.findById(id);
    }

    /**
     * Retrieves all itinerary categories with a specific description.
     *
     * @param description The description to filter itinerary categories by.
     * @return List<ItineraryCategory> - A list of ItineraryCategory objects that match the specified description.
     */
    public List<ItineraryCategory> findByDescription ( String description ) {
        return itineraryCategories_Repsitory.findByDescription(description);
    }

    /**
     * Retrieves all itinerary categories stored in the database.
     *
     * @return List<ItineraryCategory> - A list of all ItineraryCategory objects.
     */
    public List<ItineraryCategory> findAll () {
        return itineraryCategories_Repsitory.findAll();
    }
    
    // any other method for this specific object is useless: addition, deletion and update should be performed directly on the database
    
}