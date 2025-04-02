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
     * Retrieves an image by its unique identifier.
     *
     * @param id The unique identifier of the image.
     * @return Image - The Image object matching the given ID, or null if no match is found.
     */
    public Image findById ( int id ) {
        return images_Repository.findById(id);
    }

    /**
     * Retrieves all images with a specific image path.
     *
     * @param imagePath The image path to filter images by.
     * @return List<Image> - A list of Image objects that match the specified image path.
     */
    public List<Image> findByImagePath ( String imagePath ) {
        return images_Repository.findByImagePath(imagePath);
    }

}