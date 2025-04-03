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

    /**
     * Retrieves a location category-location association by the specified location category and location.
     *
     * @param category The location category to filter by.
     * @param location The location to filter by.
     * @return LocationCategory_Location - The associated location category-location, or null if no association is found.
     */
    public LocationCategory_Location findByAssociatedLocationCategoryAndAssociatedLocation (LocationCategory category , Location location ) {
        return locationCategories_Locations_Repository.findByAssociatedLocationCategoryAndAssociatedLocation(category, location);
    }

    /**
     * Retrieves a list of location categories associated with the specified location category.
     *
     * @param category The location category to filter by.
     * @return List<LocationCategory> - A list of location categories associated with the specified location category.
     */
    public List<LocationCategory> findByAssociatedLocationCategory ( LocationCategory category ) {
        return locationCategories_Locations_Repository.findByAssociatedLocationCategory(category);
    }

    /**
     * Retrieves a list of locations associated with the specified location.
     *
     * @param location The location to filter by.
     * @return List<Location> - A list of locations associated with the specified location.
     */
    public List<Location> findByAssociatedLocation ( Location location ) {
        return locationCategories_Locations_Repository.findByAssociatedLocation(location);
    }

    /**
     * Retrieves a list of all location category-location associations.
     *
     * @return List<LocationCategory_Location> - A list of all location category-location associations.
     */
    public List<LocationCategory_Location> findAll () {
        return locationCategories_Locations_Repository.findAll();
    }
    
    /**
     * Saves a location category-location association.
     *
     * @param locationCategory_Location The location category-location association to save.
     * @return LocationCategory_Location - The saved location category-location association.
     */
    public LocationCategory_Location addAssociation ( LocationCategory_Location locationCategory_Location ) {
        return locationCategories_Locations_Repository.save(locationCategory_Location);
    }

}