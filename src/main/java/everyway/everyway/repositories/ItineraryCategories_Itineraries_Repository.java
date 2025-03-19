package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.ItineraryCategory_ItineraryId;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.models.tables.ItineraryCategory;
import everyway.everyway.models.tables.ItineraryCategory_Itinerary;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface ItineraryCategories_Itineraries_Repository extends JpaRepository<ItineraryCategory_Itinerary, ItineraryCategory_ItineraryId> {
    
    ItineraryCategory_Itinerary findByAssociatedItineraryCategoryAndAssociatedItinerary(ItineraryCategory category, Itinerary itinerary);

    List<ItineraryCategory> findByAssociatedItineraryCategory(ItineraryCategory category);
    List<Itinerary> findByAssociatedItinerary(Itinerary itinerary);

    @NonNull List<ItineraryCategory_Itinerary> findAll();

}