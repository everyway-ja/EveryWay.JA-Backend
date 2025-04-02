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
     * Finds an Image_Itinerary by the associated Image and Itinerary.
     *
     * @param associatedImage the Image associated with the Image_Itinerary
     * @param associatedItinerary the Itinerary associated with the Image_Itinerary
     * @return the Image_Itinerary that matches both the associated Image and Itinerary, or null if not found
     */
    public Image_Itinerary findByAssociatedImageAndAssociatedItinerary ( Image associatedImage , Itinerary associatedItinerary ) {
        return images_Itineraries_Repository.findByAssociatedImageAndAssociatedItinerary(associatedImage, associatedItinerary);
    }

    /**
     * Finds all Image_Itinerary associations by the associated Image.
     *
     * @param associatedImage the Image associated with the Image_Itinerary
     * @return a list of Image_Itinerary associations with the specified Image
     */
    public List<Image_Itinerary> findByAssociatedImage ( Image associatedImage ) {
        return images_Itineraries_Repository.findByAssociatedImage(associatedImage);
    }

    /**
     * Finds all Image_Itinerary associations by the associated Itinerary.
     *
     * @param associatedItinerary the Itinerary associated with the Image_Itinerary
     * @return a list of Image_Itinerary associations with the specified Itinerary
     */
    public List<Image_Itinerary> findByAssociatedItinerary ( Itinerary associatedItinerary ) {
        return images_Itineraries_Repository.findByAssociatedItinerary(associatedItinerary);
    }

    /**
     * Retrieves all Image_Itinerary associations from the repository.
     *
     * @return a list of all Image_Itinerary associations
     */
    public List<Image_Itinerary> findAll () {
        return images_Itineraries_Repository.findAll();
    }


    
    // add a new association between an image and an itinerary
    public Image_Itinerary addAssociation ( Image_Itinerary image_Itinerary ) {
        return images_Itineraries_Repository.save(image_Itinerary);
    }
    
}