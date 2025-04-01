package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.LocationCategory;
import everyway.everyway.models.tables.LocationCategory_Location;
import everyway.everyway.repositories.LocationCategories_Locations_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class LocationCategories_Locations_Service {

    @Autowired private LocationCategories_Locations_Repository locationCategories_Locations_Repository;

    public LocationCategory_Location findByAssociatedLocationCategoryAndAssociatedLocation (LocationCategory category , Location location ) {
        return locationCategories_Locations_Repository.findByAssociatedLocationCategoryAndAssociatedLocation(category, location);
    }

    public List<LocationCategory> findByAssociatedLocationCategory ( LocationCategory category ) {
        return locationCategories_Locations_Repository.findByAssociatedLocationCategory(category);
    }

    public List<Location> findByAssociatedLocation ( Location location ) {
        return locationCategories_Locations_Repository.findByAssociatedLocation(location);
    }

    public List<LocationCategory_Location> findAll () {
        return locationCategories_Locations_Repository.findAll();
    }
}