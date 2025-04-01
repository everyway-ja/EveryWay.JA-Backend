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

    public LocationCategory_LocationReport findByAssociatedLocationCategoryAndAssociatedLocationReport ( LocationCategory category , LocationReport report ) {
        return locationCategories_LocationReports_Repository.findByAssociatedLocationCategoryAndAssociatedLocationReport(category, report);
    }

    public List<LocationCategory_LocationReport> findByAssociatedLocationCategory ( LocationCategory category ) {
        return locationCategories_LocationReports_Repository.findByAssociatedLocationCategory(category);
    }

    public List<LocationCategory_LocationReport> findByAssociatedLocationReport ( LocationReport report ) {
        return locationCategories_LocationReports_Repository.findByAssociatedLocationReport(report);
    }

    public List<LocationCategory_LocationReport> findAll () {
        return locationCategories_LocationReports_Repository.findAll();
    }
    
}