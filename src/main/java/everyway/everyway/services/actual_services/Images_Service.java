package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Image;
import everyway.everyway.repositories.Images_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Images_Service {

    @Autowired private Images_Repository images_Repository;

    /**
     * Finds an Image by its unique ID.
     *
     * @param id the ID of the Image
     * @return the Image with the given ID, or null if not found
     */
    public Image findById ( int id ) {
        return images_Repository.findById(id);
    }

    /**
     * Finds Images by their image path.
     *
     * @param imagePath the image path to search for
     * @return a list of Images that match the given image path
     */
    public List<Image> findByImagePath ( String imagePath ) {
        return images_Repository.findByImagePath(imagePath);
    }

    /**
     * Finds Images by their description.
     *
     * @param description the description of the Image
     * @return a list of Images that match the given description
     */
    public List<Image> findByDescription ( String description ) {
        return images_Repository.findByDescription(description);
    }

}