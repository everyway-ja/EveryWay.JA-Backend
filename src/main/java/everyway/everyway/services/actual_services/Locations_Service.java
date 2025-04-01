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

    public Location findById ( int id ) {
        return locations_Repository.findById(id);
    }

    public List<Location> findByName ( String name ) {
        return locations_Repository.findByName(name);
    }

    public List<Location> findByDescription ( String description ) {
        return locations_Repository.findByDescription(description);
    }

    public List<Location> findByAssociatedPosition ( Position position ) {
        return locations_Repository.findByAssociatedPosition(position);
    }

    public List<Location> findByAssociatedAccount ( Account account ) {
        return locations_Repository.findByAssociatedAccount(account);
    }

    public List<Location> findAll () {
        return locations_Repository.findAll();
    }
}