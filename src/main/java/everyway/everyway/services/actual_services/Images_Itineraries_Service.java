package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Image;
import everyway.everyway.models.tables.Image_Itinerary;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.repositories.Images_Itineraries_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Images_Itineraries_Service {

    @Autowired private Images_Itineraries_Repository images_Itineraries_Repository;

    /**
     * Finds an Image_Itinerary association by the associated image and itinerary.
     *
     * @param associatedImage The Image object to filter by.
     * @param associatedItinerary The Itinerary object to filter by.
     * @return Image_Itinerary - The association matching the given image and itinerary, or null if no match is found.
     */
    public Image_Itinerary findByAssociatedImageAndAssociatedItinerary ( Image associatedImage , Itinerary associatedItinerary ) {
        return images_Itineraries_Repository.findByAssociatedImageAndAssociatedItinerary(associatedImage, associatedItinerary);
    }

    /**
     * Retrieves all Image_Itinerary associations for a specific image.
     *
     * @param associatedImage The Image object to filter by.
     * @return List<Image_Itinerary> - A list of Image_Itinerary associations linked to the specified image.
     */
    public List<Image_Itinerary> findByAssociatedImage ( Image associatedImage ) {
        return images_Itineraries_Repository.findByAssociatedImage(associatedImage);
    }

    /**
     * Retrieves all Image_Itinerary associations for a specific itinerary.
     *
     * @param associatedItinerary The Itinerary object to filter by.
     * @return List<Image_Itinerary> - A list of Image_Itinerary associations linked to the specified itinerary.
     */
    public List<Image_Itinerary> findByAssociatedItinerary ( Itinerary associatedItinerary ) {
        return images_Itineraries_Repository.findByAssociatedItinerary(associatedItinerary);
    }

    /**
     * Retrieves all Image_Itinerary associations stored in the database.
     *
     * @return List<Image_Itinerary> - A list of all Image_Itinerary associations.
     */
    public List<Image_Itinerary> findAll () {
        return images_Itineraries_Repository.findAll();
    }

    // add a new association between an image and an itinerary
    public Image_Itinerary addAssociation ( Image_Itinerary image_Itinerary ) {
        return images_Itineraries_Repository.save(image_Itinerary);
    }
    
}