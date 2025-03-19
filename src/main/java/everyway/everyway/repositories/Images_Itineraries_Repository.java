package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.Image_ItineraryId;
import everyway.everyway.models.tables.Image;
import everyway.everyway.models.tables.Image_Itinerary;
import everyway.everyway.models.tables.Itinerary;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface Images_Itineraries_Repository extends JpaRepository<Image_Itinerary , Image_ItineraryId> {

    Image_Itinerary findByAssociatedImageAndAssociatedItinerary(Image associatedImage, Itinerary associatedItinerary);

    List<Image_Itinerary> findByAssociatedImage(Image associatedImage);
    List<Image_Itinerary> findByAssociatedItinerary(Itinerary associatedItinerary);

    @NonNull List<Image_Itinerary> findAll();

}