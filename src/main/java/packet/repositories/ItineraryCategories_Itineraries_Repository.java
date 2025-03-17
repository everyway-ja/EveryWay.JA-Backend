package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.ItineraryCategory_ItineraryId;
import java.util.List;
import packet.model.tables.Itinerary;
import packet.model.tables.ItineraryCategory;
import packet.model.tables.ItineraryCategory_Itinerary;

@Repository

public interface ItineraryCategories_Itineraries_Repository extends JpaRepository<ItineraryCategory_Itinerary, ItineraryCategory_ItineraryId> {
    
    ItineraryCategory_Itinerary findByAssociatedItineraryCategoryAndAssociatedItinerary(ItineraryCategory category, Itinerary itinerary);

    List<ItineraryCategory> findByAssociatedItineraryCategory(ItineraryCategory category);
    List<Itinerary> findByAssociatedItinerary(Itinerary itinerary);

}