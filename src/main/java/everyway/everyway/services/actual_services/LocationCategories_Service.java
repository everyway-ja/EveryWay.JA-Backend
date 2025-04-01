package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.LocationCategory;
import everyway.everyway.repositories.LocationCategories_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class LocationCategories_Service {

    @Autowired private LocationCategories_Repository locationCategories_Repository;

    public LocationCategory findById ( int id ) {
        return locationCategories_Repository.findById(id);
    }

    public List<LocationCategory> findByDescription ( String description ) {
        return locationCategories_Repository.findByDescription(description);
    }

    public List<LocationCategory> findAll () {
        return locationCategories_Repository.findAll();
    }
    
    // any other method for this specific object is useless: addition, deletion and update should be performed directly on the database

}