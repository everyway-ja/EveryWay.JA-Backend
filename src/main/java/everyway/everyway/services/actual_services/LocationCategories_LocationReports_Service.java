package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.LocationCategory;
import everyway.everyway.models.tables.LocationCategory_LocationReport;
import everyway.everyway.models.tables.LocationReport;
import everyway.everyway.repositories.LocationCategories_LocationReports_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class LocationCategories_LocationReports_Service {

    @Autowired private LocationCategories_LocationReports_Repository locationCategories_LocationReports_Repository;

    /**
     * Retrieves a location category-location report association by the specified location category and location report.
     * 
     * This method queries the repository to find the association between the specified location category and location report.
     * 
     * @param category the location category to search for
     * @param report the location report to search for
     * @return the associated location category-location report, or null if no association is found
     */
    public LocationCategory_LocationReport findByAssociatedLocationCategoryAndAssociatedLocationReport ( LocationCategory category , LocationReport report ) {
        return locationCategories_LocationReports_Repository.findByAssociatedLocationCategoryAndAssociatedLocationReport(category, report);
    }

    /**
     * Retrieves a list of location category-location report associations by the specified location category.
     * 
     * This method queries the repository to find all associations that involve the specified location category.
     * 
     * @param category the location category to search for
     * @return a list of location category-location report associations
     */
    public List<LocationCategory_LocationReport> findByAssociatedLocationCategory ( LocationCategory category ) {
        return locationCategories_LocationReports_Repository.findByAssociatedLocationCategory(category);
    }

    /**
     * Retrieves a list of location category-location report associations by the specified location report.
     * 
     * This method queries the repository to find all associations that involve the specified location report.
     * 
     * @param report the location report to search for
     * @return a list of location category-location report associations
     */
    public List<LocationCategory_LocationReport> findByAssociatedLocationReport ( LocationReport report ) {
        return locationCategories_LocationReports_Repository.findByAssociatedLocationReport(report);
    }

    /**
     * Retrieves a list of all location category-location report associations.
     * 
     * This method queries the repository to return all the available location category-location report associations.
     * 
     * @return a list of all location category-location report associations
     */
    public List<LocationCategory_LocationReport> findAll () {
        return locationCategories_LocationReports_Repository.findAll();
    }
    
}