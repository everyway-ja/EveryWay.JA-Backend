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
     * This method queries the repository to find the association between the specified location category and location.
     * 
     * @param category the location category to search for
     * @param location the location to search for
     * @return the associated location category-location, or null if no association is found
     */
    public LocationCategory_Location findByAssociatedLocationCategoryAndAssociatedLocation (LocationCategory category , Location location ) {
        return locationCategories_Locations_Repository.findByAssociatedLocationCategoryAndAssociatedLocation(category, location);
    }

    /**
     * Retrieves a list of location categories that are associated with the specified location category.
     * 
     * This method queries the repository to find all location categories that are associated with the given location category.
     * 
     * @param category the location category to search for
     * @return a list of location categories associated with the specified location category
     */
    public List<LocationCategory> findByAssociatedLocationCategory ( LocationCategory category ) {
        return locationCategories_Locations_Repository.findByAssociatedLocationCategory(category);
    }

    /**
     * Retrieves a list of locations that are associated with the specified location.
     * 
     * This method queries the repository to find all locations that are associated with the given location.
     * 
     * @param location the location to search for
     * @return a list of locations associated with the specified location
     */
    public List<Location> findByAssociatedLocation ( Location location ) {
        return locationCategories_Locations_Repository.findByAssociatedLocation(location);
    }

    /**
     * Retrieves a list of all location category-location associations.
     * 
     * This method queries the repository to return all the available location category-location associations.
     * 
     * @return a list of all location category-location associations
     */
    public List<LocationCategory_Location> findAll () {
        return locationCategories_Locations_Repository.findAll();
    }
    
}