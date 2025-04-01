
package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.LocationCategory_LocationId;
import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.LocationCategory;
import everyway.everyway.models.tables.LocationCategory_Location;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface LocationCategories_Locations_Repository extends JpaRepository<LocationCategory_Location , LocationCategory_LocationId> {

    LocationCategory_Location findByAssociatedLocationCategoryAndAssociatedLocation(LocationCategory category, Location location);

    List<LocationCategory> findByAssociatedLocationCategory(LocationCategory category);
    List<Location> findByAssociatedLocation(Location location);

    @NonNull List<LocationCategory_Location> findAll();

}