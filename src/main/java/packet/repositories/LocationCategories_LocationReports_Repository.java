package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.LocationCategory_LocationReportId;
import packet.model.tables.*;

import java.util.List;

@Repository
public interface LocationCategories_LocationReports_Repository extends JpaRepository<LocationCategory_LocationReport, LocationCategory_LocationReportId> {

    LocationCategory_LocationReport findByAssociatedLocationCategoryAndAssociatedLocationReport (LocationCategory associatedLocationCategory, LocationReport associatedLocationReport);

    List<LocationCategory_LocationReport> findByAssociatedLocationCategory(LocationCategory associatedLocationCategory);
    List<LocationCategory_LocationReport> findByAssociatedLocationReport(LocationReport associatedLocationReport);

}