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
     * This method queries the repository to find a location report with the specified ID.
     * 
     * @param id the ID of the location report to search for
     * @return the location report with the specified ID, or null if not found
     */
    public LocationReport findById ( int id ) {
        return locationReports_Repository.findById(id);
    }

    /**
     * Retrieves a list of location reports by their name.
     * 
     * This method queries the repository to find location reports with the specified name.
     * 
     * @param name the name of the location reports to search for
     * @return a list of location reports that match the specified name
     */
    public List<LocationReport> findByName ( String name ) {
        return locationReports_Repository.findByName(name);
    }

    /**
     * Retrieves a list of location reports by their description.
     * 
     * This method queries the repository to find location reports with the specified description.
     * 
     * @param description the description of the location reports to search for
     * @return a list of location reports that match the specified description
     */
    public List<LocationReport> findByDescription ( String description ) {
        return locationReports_Repository.findByDescription(description);
    }

    /**
     * Retrieves a list of location reports associated with a specific account.
     * 
     * This method queries the repository to find location reports associated with the given account.
     * 
     * @param account the account to search for associated location reports
     * @return a list of location reports associated with the specified account
     */
    public List<LocationReport> findByAssociatedAccount ( Account account ) {
        return locationReports_Repository.findByAssociatedAccount(account);
    }

    /**
     * Retrieves a list of location reports associated with a specific position.
     * 
     * This method queries the repository to find location reports associated with the given position.
     * 
     * @param position the position to search for associated location reports
     * @return a list of location reports associated with the specified position
     */
    public List<LocationReport> findByAssociatedPosition ( Position position ) {
        return locationReports_Repository.findByAssociatedPosition(position);
    }

    /**
     * Retrieves a list of all location reports.
     * 
     * This method queries the repository to return all available location reports in the database.
     * 
     * @return a list of all location reports
     */
    public List<LocationReport> findAll () {
        return locationReports_Repository.findAll();
    }
    
}