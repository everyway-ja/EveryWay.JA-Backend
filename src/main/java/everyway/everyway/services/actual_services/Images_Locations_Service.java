package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Image;
import everyway.everyway.models.tables.Image_Location;
import everyway.everyway.models.tables.Location;
import everyway.everyway.repositories.Images_Locations_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Images_Locations_Service {

    @Autowired private Images_Locations_Repository images_Locations_Repository;

    /**
     * Finds an Image_Location by the associated Image and Location.
     *
     * @param associatedImage the Image to look for
     * @param associatedLocation the Location to look for
     * @return the Image_Location matching both Image and Location, or null if not found
     */
    public Image_Location findByAssociatedImageAndAssociatedLocation ( Image associatedImage , Location associatedLocation ) {
        return images_Locations_Repository.findByAssociatedImageAndAssociatedLocation(associatedImage, associatedLocation);
    }

    /**
     * Finds all Image_Location associations for a given Image.
     *
     * @param associatedImage the Image to look for
     * @return a list of Image_Location associations for the given Image
     */
    public List<Image_Location> findByAssociatedImage ( Image associatedImage ) {
        return images_Locations_Repository.findByAssociatedImage(associatedImage);
    }

    /**
     * Finds all Image_Location associations for a given Location.
     *
     * @param associatedLocation the Location to look for
     * @return a list of Image_Location associations for the given Location
     */
    public List<Image_Location> findByAssociatedLocation ( Location associatedLocation ) {
        return images_Locations_Repository.findByAssociatedLocation(associatedLocation);
    }

    /**
     * Retrieves all Image_Location associations.
     *
     * @return a list of all Image_Location associations
     */
    public List<Image_Location> findAll () {
        return images_Locations_Repository.findAll();
    }

}