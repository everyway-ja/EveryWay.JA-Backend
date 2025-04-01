package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Image;
import everyway.everyway.repositories.Images_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Images_Service {

    @Autowired private Images_Repository images_Repository;

    public Image findById ( int id ) {
        return images_Repository.findById(id);
    }

    public List<Image> findByImagePath ( String imagePath ) {
        return images_Repository.findByImagePath(imagePath);
    }

    public List<Image> findByDescription ( String description ) {
        return images_Repository.findByDescription(description);
    }
}