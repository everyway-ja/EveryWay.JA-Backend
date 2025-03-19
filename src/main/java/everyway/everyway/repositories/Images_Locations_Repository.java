package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.Image_LocationId;
import everyway.everyway.models.tables.Image;
import everyway.everyway.models.tables.Image_Location;
import everyway.everyway.models.tables.Location;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface Images_Locations_Repository extends JpaRepository<Image_Location , Image_LocationId> {

    Image_Location findByAssociatedImageAndAssociatedLocation(Image associatedImage, Location associatedLocation);

    List<Image_Location> findByAssociatedImage(Image associatedImage);
    List<Image_Location> findByAssociatedLocation(Location associatedLocation);

    @NonNull List<Image_Location> findAll();

}