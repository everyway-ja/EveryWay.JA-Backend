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

    public Image_Location findByAssociatedImageAndAssociatedLocation ( Image associatedImage , Location associatedLocation ) {
        return images_Locations_Repository.findByAssociatedImageAndAssociatedLocation(associatedImage, associatedLocation);
    }

    public List<Image_Location> findByAssociatedImage ( Image associatedImage ) {
        return images_Locations_Repository.findByAssociatedImage(associatedImage);
    }

    public List<Image_Location> findByAssociatedLocation ( Location associatedLocation ) {
        return images_Locations_Repository.findByAssociatedLocation(associatedLocation);
    }

    public List<Image_Location> findAll () {
        return images_Locations_Repository.findAll();
    }

}