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
     * @param category the ItineraryCategory
     * @param itinerary the Itinerary
     * @return the ItineraryCategory_Itinerary that associates the given category with the itinerary
     */
    public ItineraryCategory_Itinerary findByAssociatedItineraryCategoryAndAssociatedItinerary ( ItineraryCategory category , Itinerary itinerary ) {
        return itineraryCategories_Itineraries_Repository.findByAssociatedItineraryCategoryAndAssociatedItinerary(category, itinerary);
    }

    /**
     * Finds all ItineraryCategory_Itinerary associations for a given ItineraryCategory.
     *
     * @param category the ItineraryCategory
     * @return a list of ItineraryCategory_Itinerary associations linked to the given category
     */
    public List<ItineraryCategory> findByAssociatedItineraryCategory ( ItineraryCategory category ) {
        return itineraryCategories_Itineraries_Repository.findByAssociatedItineraryCategory(category);
    }

    /**
     * Finds all ItineraryCategory_Itinerary associations for a given Itinerary.
     *
     * @param itinerary the Itinerary
     * @return a list of ItineraryCategory_Itinerary associations linked to the given itinerary
     */
    public List<Itinerary> findByAssociatedItinerary ( Itinerary itinerary ) {
        return itineraryCategories_Itineraries_Repository.findByAssociatedItinerary(itinerary);
    }

    /**
     * Finds all ItineraryCategory_Itinerary associations.
     *
     * @return a list of all ItineraryCategory_Itinerary associations
     */
    public List<ItineraryCategory_Itinerary> findAll () {
        return itineraryCategories_Itineraries_Repository.findAll();
    }



    // add a new association between itinerary and category
    public ItineraryCategory_Itinerary addAssociation ( ItineraryCategory_Itinerary itineraryCategory_Itinerary ) {
        return itineraryCategories_Itineraries_Repository.save(itineraryCategory_Itinerary);
    }
    
}