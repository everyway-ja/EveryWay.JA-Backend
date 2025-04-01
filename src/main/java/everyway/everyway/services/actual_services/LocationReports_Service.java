package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.LocationReport;
import everyway.everyway.models.tables.Position;
import everyway.everyway.repositories.LocationReports_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class LocationReports_Service {

    @Autowired private LocationReports_Repository locationReports_Repository;

    public LocationReport findById ( int id ) {
        return locationReports_Repository.findById(id);
    }

    public List<LocationReport> findByName ( String name ) {
        return locationReports_Repository.findByName(name);
    }

    public List<LocationReport> findByDescription ( String description ) {
        return locationReports_Repository.findByDescription(description);
    }

    public List<LocationReport> findByAssociatedAccount ( Account account ) {
        return locationReports_Repository.findByAssociatedAccount(account);
    }

    public List<LocationReport> findByAssociatedPosition ( Position position ) {
        return locationReports_Repository.findByAssociatedPosition(position);
    }

    public List<LocationReport> findAll () {
        return locationReports_Repository.findAll();
    }
    
}