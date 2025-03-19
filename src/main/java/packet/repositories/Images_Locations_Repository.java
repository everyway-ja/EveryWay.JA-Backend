package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.Image_LocationId;
import packet.model.tables.Image_Location;
import java.util.List;
import org.springframework.lang.NonNull;
import packet.model.tables.Image;
import packet.model.tables.Location;

@Repository

public interface Images_Locations_Repository extends JpaRepository<Image_Location , Image_LocationId> {

    Image_Location findByAssociatedImageAndAssociatedLocation(Image associatedImage, Location associatedLocation);

    List<Image_Location> findByAssociatedImage(Image associatedImage);
    List<Image_Location> findByAssociatedLocation(Location associatedLocation);

    @NonNull List<Image_Location> findAll();

}