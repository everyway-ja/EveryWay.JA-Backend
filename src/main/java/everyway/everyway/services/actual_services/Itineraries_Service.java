package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.repositories.Itineraries_Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Itineraries_Service {

    @Autowired private Itineraries_Repositories itineraries_Repositories;

    public Itinerary findById ( int id ) {
        return itineraries_Repositories.findById(id);
    }

    public List<Itinerary> findByName ( String name ) {
        return itineraries_Repositories.findByName(name);
    }

    public List<Itinerary> findByDescription ( String description ) {
        return itineraries_Repositories.findByDescription(description);
    }

    public List<Itinerary> findByAssociatedAccount ( Account account ) {
        return itineraries_Repositories.findByAssociatedAccount(account);
    }

    public List<Itinerary> findAll () {
        return itineraries_Repositories.findAll();
    }
}