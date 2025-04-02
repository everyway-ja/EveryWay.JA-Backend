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

    /**
     * Retrieves a location report by its ID.
     *
     * @param id The unique identifier of the location report.
     * @return LocationReport - The location report with the specified ID, or null if not found.
     */
    public LocationReport findById ( int id ) {
        return locationReports_Repository.findById(id);
    }

    /**
     * Retrieves a list of location reports by their name.
     *
     * @param name The name to filter location reports by.
     * @return List<LocationReport> - A list of location reports that match the specified name.
     */
    public List<LocationReport> findByName ( String name ) {
        return locationReports_Repository.findByName(name);
    }

    /**
     * Retrieves a list of location reports by their description.
     *
     * @param description The description to filter location reports by.
     * @return List<LocationReport> - A list of location reports that match the specified description.
     */
    public List<LocationReport> findByDescription ( String description ) {
        return locationReports_Repository.findByDescription(description);
    }

    /**
     * Retrieves a list of location reports associated with a specific account.
     *
     * @param account The Account object to filter location reports by.
     * @return List<LocationReport> - A list of location reports associated with the specified account.
     */
    public List<LocationReport> findByAssociatedAccount ( Account account ) {
        return locationReports_Repository.findByAssociatedAccount(account);
    }

    /**
     * Retrieves a list of location reports associated with a specific position.
     *
     * @param position The Position object to filter location reports by.
     * @return List<LocationReport> - A list of location reports associated with the specified position.
     */
    public List<LocationReport> findByAssociatedPosition ( Position position ) {
        return locationReports_Repository.findByAssociatedPosition(position);
    }

    /**
     * Retrieves a list of all location reports.
     *
     * @return List<LocationReport> - A list of all location reports in the database.
     */
    public List<LocationReport> findAll () {
        return locationReports_Repository.findAll();
    }
    
}