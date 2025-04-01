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

    public ItineraryCategory_Itinerary findByAssociatedItineraryCategoryAndAssociatedItinerary ( ItineraryCategory category , Itinerary itinerary ) {
        return itineraryCategories_Itineraries_Repository.findByAssociatedItineraryCategoryAndAssociatedItinerary(category, itinerary);
    }

    public List<ItineraryCategory> findByAssociatedItineraryCategory ( ItineraryCategory category ) {
        return itineraryCategories_Itineraries_Repository.findByAssociatedItineraryCategory(category);
    }

    public List<Itinerary> findByAssociatedItinerary ( Itinerary itinerary ) {
        return itineraryCategories_Itineraries_Repository.findByAssociatedItinerary(itinerary);
    }

    public List<ItineraryCategory_Itinerary> findAll () {
        return itineraryCategories_Itineraries_Repository.findAll();
    }
}