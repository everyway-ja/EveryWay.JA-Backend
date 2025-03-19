package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.LocationCategory_LocationReportId;
import everyway.everyway.models.tables.LocationCategory;
import everyway.everyway.models.tables.LocationCategory_LocationReport;
import everyway.everyway.models.tables.LocationReport;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface LocationCategories_LocationReports_Repository extends JpaRepository<LocationCategory_LocationReport, LocationCategory_LocationReportId> {

    LocationCategory_LocationReport findByAssociatedLocationCategoryAndAssociatedLocationReport (LocationCategory associatedLocationCategory, LocationReport associatedLocationReport);

    List<LocationCategory_LocationReport> findByAssociatedLocationCategory(LocationCategory associatedLocationCategory);
    List<LocationCategory_LocationReport> findByAssociatedLocationReport(LocationReport associatedLocationReport);

    @NonNull List<LocationCategory_LocationReport> findAll();

}