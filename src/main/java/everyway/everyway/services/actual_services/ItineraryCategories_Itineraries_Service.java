package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.models.tables.ItineraryCategory;
import everyway.everyway.models.tables.ItineraryCategory_Itinerary;
import everyway.everyway.repositories.ItineraryCategories_Itineraries_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ItineraryCategories_Itineraries_Service {

    @Autowired private ItineraryCategories_Itineraries_Repository itineraryCategories_Itineraries_Repository;

    /**
     * Finds a specific ItineraryCategory_Itinerary association by the associated category and itinerary.
     *
     * @param category The ItineraryCategory object to filter by.
     * @param itinerary The Itinerary object to filter by.
     * @return ItineraryCategory_Itinerary - The association matching the given category and itinerary, or null if no match is found.
     */
    public ItineraryCategory_Itinerary findByAssociatedItineraryCategoryAndAssociatedItinerary ( ItineraryCategory category , Itinerary itinerary ) {
        return itineraryCategories_Itineraries_Repository.findByAssociatedItineraryCategoryAndAssociatedItinerary(category, itinerary);
    }

    /**
     * Retrieves all ItineraryCategory_Itinerary associations for a specific category.
     *
     * @param category The ItineraryCategory object to filter by.
     * @return List<ItineraryCategory> - A list of ItineraryCategory_Itinerary associations linked to the specified category.
     */
    public List<ItineraryCategory> findByAssociatedItineraryCategory ( ItineraryCategory category ) {
        return itineraryCategories_Itineraries_Repository.findByAssociatedItineraryCategory(category);
    }

    /**
     * Retrieves all ItineraryCategory_Itinerary associations for a specific itinerary.
     *
     * @param itinerary The Itinerary object to filter by.
     * @return List<Itinerary> - A list of ItineraryCategory_Itinerary associations linked to the specified itinerary.
     */
    public List<Itinerary> findByAssociatedItinerary ( Itinerary itinerary ) {
        return itineraryCategories_Itineraries_Repository.findByAssociatedItinerary(itinerary);
    }

    /**
     * Retrieves all ItineraryCategory_Itinerary associations stored in the database.
     *
     * @return List<ItineraryCategory_Itinerary> - A list of all ItineraryCategory_Itinerary associations.
     */
    public List<ItineraryCategory_Itinerary> findAll () {
        return itineraryCategories_Itineraries_Repository.findAll();
    }



    // add a new association between itinerary and category
    public ItineraryCategory_Itinerary addAssociation ( ItineraryCategory_Itinerary itineraryCategory_Itinerary ) {
        return itineraryCategories_Itineraries_Repository.save(itineraryCategory_Itinerary);
    }
    
}