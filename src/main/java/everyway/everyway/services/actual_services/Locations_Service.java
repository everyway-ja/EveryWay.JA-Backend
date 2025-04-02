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
     * @param id The unique identifier of the location.
     * @return Location - The location with the specified ID, or null if not found.
     */
    public Location findById ( int id ) {
        return locations_Repository.findById(id);
    }

    /**
     * Retrieves a list of locations by name.
     *
     * @param name The name to filter locations by.
     * @return List<Location> - A list of locations that match the specified name.
     */
    public List<Location> findByName ( String name ) {
        return locations_Repository.findByName(name);
    }

    /**
     * Retrieves a list of locations by description.
     *
     * @param description The description to filter locations by.
     * @return List<Location> - A list of locations that match the specified description.
     */
    public List<Location> findByDescription ( String description ) {
        return locations_Repository.findByDescription(description);
    }

    /**
     * Retrieves a list of locations by associated position.
     *
     * @param position The Position object to filter locations by.
     * @return List<Location> - A list of locations associated with the specified position.
     */
    public List<Location> findByAssociatedPosition ( Position position ) {
        return locations_Repository.findByAssociatedPosition(position);
    }

    /**
     * Retrieves a list of locations by associated account.
     *
     * @param account The Account object to filter locations by.
     * @return List<Location> - A list of locations associated with the specified account.
     */
    public List<Location> findByAssociatedAccount ( Account account ) {
        return locations_Repository.findByAssociatedAccount(account);
    }

    /**
     * Retrieves a list of all locations.
     *
     * @return List<Location> - A list of all locations in the database.
     */
    public List<Location> findAll () {
        return locations_Repository.findAll();
    }
    
}