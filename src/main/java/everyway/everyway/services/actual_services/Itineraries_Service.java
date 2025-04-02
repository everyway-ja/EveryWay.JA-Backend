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

    /**
     * Finds an Itinerary by its ID.
     *
     * @param id the ID of the Itinerary
     * @return the Itinerary that matches the given ID
     */
    public Itinerary findById ( int id ) {
        return itineraries_Repositories.findById(id);
    }

    /**
     * Finds Itineraries by their name.
     *
     * @param name the name of the Itinerary
     * @return a list of Itineraries that match the given name
     */
    public List<Itinerary> findByName ( String name ) {
        return itineraries_Repositories.findByName(name);
    }

    /**
     * Finds Itineraries by their description.
     *
     * @param description the description of the Itinerary
     * @return a list of Itineraries that match the given description
     */
    public List<Itinerary> findByDescription ( String description ) {
        return itineraries_Repositories.findByDescription(description);
    }

    /**
     * Finds Itineraries by the associated Account.
     *
     * @param account the associated Account
     * @return a list of Itineraries associated with the given Account
     */
    public List<Itinerary> findByAssociatedAccount ( Account account ) {
        return itineraries_Repositories.findByAssociatedAccount(account);
    }

    /**
     * Finds all Itineraries.
     *
     * @return a list of all Itineraries
     */
    public List<Itinerary> findAll () {
        return itineraries_Repositories.findAll();
    }


    // add a new itinerary
    public Itinerary addItinerary ( Itinerary itinerary ) {
        return itineraries_Repositories.save(itinerary);
    }
    
}