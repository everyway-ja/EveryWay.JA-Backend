package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.Image_ItineraryId;
import packet.model.tables.Image_Itinerary;
import java.util.List;
import org.springframework.lang.NonNull;
import packet.model.tables.Image;
import packet.model.tables.Itinerary;

@Repository

public interface Images_Itineraries_Repository extends JpaRepository<Image_Itinerary , Image_ItineraryId> {

    Image_Itinerary findByAssociatedImageAndAssociatedItinerary(Image associatedImage, Itinerary associatedItinerary);

    List<Image_Itinerary> findByAssociatedImage(Image associatedImage);
    List<Image_Itinerary> findByAssociatedItinerary(Itinerary associatedItinerary);

    @NonNull List<Image_Itinerary> findAll();

}