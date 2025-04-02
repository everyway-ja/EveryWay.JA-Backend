package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.LocationCategory;
import everyway.everyway.repositories.LocationCategories_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class LocationCategories_Service {

    @Autowired private LocationCategories_Repository locationCategories_Repository;

    /**
     * Retrieves a location category by its ID.
     *
     * @param id The unique identifier of the location category.
     * @return LocationCategory - The location category with the specified ID, or null if not found.
     */
    public LocationCategory findById ( int id ) {
        return locationCategories_Repository.findById(id);
    }

    /**
     * Retrieves a list of location categories by the specified description.
     *
     * @param description The description to filter location categories by.
     * @return List<LocationCategory> - A list of location categories that match the specified description.
     */
    public List<LocationCategory> findByDescription ( String description ) {
        return locationCategories_Repository.findByDescription(description);
    }

    /**
     * Retrieves a list of all location categories.
     *
     * @return List<LocationCategory> - A list of all location categories in the database.
     */
    public List<LocationCategory> findAll () {
        return locationCategories_Repository.findAll();
    }
    
    // any other method for this specific object is useless: addition, deletion and update should be performed directly on the database

}