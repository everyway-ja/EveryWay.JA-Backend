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
     * Finds an Image_Location association by the associated image and location.
     *
     * @param associatedImage The Image object to filter by.
     * @param associatedLocation The Location object to filter by.
     * @return Image_Location - The association matching the given image and location, or null if no match is found.
     */
    public Image_Location findByAssociatedImageAndAssociatedLocation ( Image associatedImage , Location associatedLocation ) {
        return images_Locations_Repository.findByAssociatedImageAndAssociatedLocation(associatedImage, associatedLocation);
    }

    /**
     * Retrieves all Image_Location associations for a specific image.
     *
     * @param associatedImage The Image object to filter by.
     * @return List<Image_Location> - A list of Image_Location associations linked to the specified image.
     */
    public List<Image_Location> findByAssociatedImage ( Image associatedImage ) {
        return images_Locations_Repository.findByAssociatedImage(associatedImage);
    }

    /**
     * Retrieves all Image_Location associations for a specific location.
     *
     * @param associatedLocation The Location object to filter by.
     * @return List<Image_Location> - A list of Image_Location associations linked to the specified location.
     */
    public List<Image_Location> findByAssociatedLocation ( Location associatedLocation ) {
        return images_Locations_Repository.findByAssociatedLocation(associatedLocation);
    }

    /**
     * Retrieves all Image_Location associations stored in the database.
     *
     * @return List<Image_Location> - A list of all Image_Location associations.
     */
    public List<Image_Location> findAll () {
        return images_Locations_Repository.findAll();
    }

    /**
     * Saves a new Image_Location association to the database.
     *
     * @param image_Location The Image_Location object to save.
     * @return Image_Location - The saved Image_Location object.
     */
    public Image_Location addAssociation ( Image_Location image_Location ) {
        return images_Locations_Repository.save(image_Location);
    }

}