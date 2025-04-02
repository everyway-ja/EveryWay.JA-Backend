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
     * @param category The location category to filter by.
     * @param report The location report to filter by.
     * @return LocationCategory_LocationReport - The associated location category-location report, or null if no association is found.
     */
    public LocationCategory_LocationReport findByAssociatedLocationCategoryAndAssociatedLocationReport ( LocationCategory category , LocationReport report ) {
        return locationCategories_LocationReports_Repository.findByAssociatedLocationCategoryAndAssociatedLocationReport(category, report);
    }

    /**
     * Retrieves a list of location category-location report associations by the specified location category.
     *
     * @param category The location category to filter by.
     * @return List<LocationCategory_LocationReport> - A list of associations involving the specified location category.
     */
    public List<LocationCategory_LocationReport> findByAssociatedLocationCategory ( LocationCategory category ) {
        return locationCategories_LocationReports_Repository.findByAssociatedLocationCategory(category);
    }

    /**
     * Retrieves a list of location category-location report associations by the specified location report.
     *
     * @param report The location report to filter by.
     * @return List<LocationCategory_LocationReport> - A list of associations involving the specified location report.
     */
    public List<LocationCategory_LocationReport> findByAssociatedLocationReport ( LocationReport report ) {
        return locationCategories_LocationReports_Repository.findByAssociatedLocationReport(report);
    }

    /**
     * Retrieves a list of all location category-location report associations.
     *
     * @return List<LocationCategory_LocationReport> - A list of all location category-location report associations.
     */
    public List<LocationCategory_LocationReport> findAll () {
        return locationCategories_LocationReports_Repository.findAll();
    }
    
}