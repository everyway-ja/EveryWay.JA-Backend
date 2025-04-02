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

    public Image_Itinerary findByAssociatedImageAndAssociatedItinerary ( Image associatedImage , Itinerary associatedItinerary ) {
        return images_Itineraries_Repository.findByAssociatedImageAndAssociatedItinerary(associatedImage, associatedItinerary);
    }

    public List<Image_Itinerary> findByAssociatedImage ( Image associatedImage ) {
        return images_Itineraries_Repository.findByAssociatedImage(associatedImage);
    }

    public List<Image_Itinerary> findByAssociatedItinerary ( Itinerary associatedItinerary ) {
        return images_Itineraries_Repository.findByAssociatedItinerary(associatedItinerary);
    }

    public List<Image_Itinerary> findAll () {
        return images_Itineraries_Repository.findAll();
    }


    
    // add a new association between an image and an itinerary
    public Image_Itinerary addAssociation ( Image_Itinerary image_Itinerary ) {
        return images_Itineraries_Repository.save(image_Itinerary);
    }
    
}