package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.LocationCategory_LocationId;
import java.util.List;
import packet.model.tables.LocationCategory_Location;
import packet.model.tables.LocationCategory;
import packet.model.tables.Location;

@Repository
public interface LocationCategories_Locations_Repository extends JpaRepository<LocationCategory_Location , LocationCategory_LocationId> {

    LocationCategory_Location findByAssociatedLocationCategoryAndAssociatedLocation(LocationCategory category, Location location);

    List<packet.model.tables.LocationCategory> findByAssociatedLocationCategory(LocationCategory category);
    List<packet.model.tables.Location> findByAssociatedLocation(Location location);

}