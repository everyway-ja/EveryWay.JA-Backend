package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.Position;
import everyway.everyway.repositories.Locations_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Locations_Service {

    @Autowired private Locations_Repository locations_Repository;

    /**
     * Retrieves a location by its ID.
     * 
     * This method queries the repository to find a location with the specified ID.
     * 
     * @param id the ID of the location to search for
     * @return the location with the specified ID, or null if not found
     */
    public Location findById ( int id ) {
        return locations_Repository.findById(id);
    }

    /**
     * Retrieves a list of locations by name.
     * 
     * This method queries the repository to find locations with the specified name.
     * 
     * @param name the name of the locations to search for
     * @return a list of locations that match the specified name
     */
    public List<Location> findByName ( String name ) {
        return locations_Repository.findByName(name);
    }

    /**
     * Retrieves a list of locations by description.
     * 
     * This method queries the repository to find locations with the specified description.
     * 
     * @param description the description of the locations to search for
     * @return a list of locations that match the specified description
     */
    public List<Location> findByDescription ( String description ) {
        return locations_Repository.findByDescription(description);
    }

    /**
     * Retrieves a list of locations by associated position.
     * 
     * This method queries the repository to find locations associated with the specified position.
     * 
     * @param position the position associated with the locations to search for
     * @return a list of locations that are associated with the specified position
     */
    public List<Location> findByAssociatedPosition ( Position position ) {
        return locations_Repository.findByAssociatedPosition(position);
    }

    /**
     * Retrieves a list of locations by associated account.
     * 
     * This method queries the repository to find locations associated with the specified account.
     * 
     * @param account the account associated with the locations to search for
     * @return a list of locations that are associated with the specified account
     */
    public List<Location> findByAssociatedAccount ( Account account ) {
        return locations_Repository.findByAssociatedAccount(account);
    }

    /**
     * Retrieves a list of all locations.
     * 
     * This method queries the repository to return all available locations in the database.
     * 
     * @return a list of all locations
     */
    public List<Location> findAll () {
        return locations_Repository.findAll();
    }
    
}