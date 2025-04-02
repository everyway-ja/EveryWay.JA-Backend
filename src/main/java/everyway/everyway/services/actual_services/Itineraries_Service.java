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
     * Retrieves an itinerary by its unique identifier.
     *
     * @param id The unique identifier of the itinerary.
     * @return Itinerary - The Itinerary object matching the given ID, or null if no match is found.
     */
    public Itinerary findById ( int id ) {
        return itineraries_Repositories.findById(id);
    }

    /**
     * Retrieves all itineraries with a specific name.
     *
     * @param name The name to filter itineraries by.
     * @return List<Itinerary> - A list of Itinerary objects that match the specified name.
     */
    public List<Itinerary> findByName ( String name ) {
        return itineraries_Repositories.findByName(name);
    }

    /**
     * Retrieves all itineraries with a specific description.
     *
     * @param description The description to filter itineraries by.
     * @return List<Itinerary> - A list of Itinerary objects that match the specified description.
     */
    public List<Itinerary> findByDescription ( String description ) {
        return itineraries_Repositories.findByDescription(description);
    }

    /**
     * Retrieves all itineraries associated with a specific account.
     *
     * @param account The Account object to filter itineraries by.
     * @return List<Itinerary> - A list of Itinerary objects linked to the specified account.
     */
    public List<Itinerary> findByAssociatedAccount ( Account account ) {
        return itineraries_Repositories.findByAssociatedAccount(account);
    }

    /**
     * Retrieves all itineraries stored in the database.
     *
     * @return List<Itinerary> - A list of all Itinerary objects.
     */
    public List<Itinerary> findAll () {
        return itineraries_Repositories.findAll();
    }


    // add a new itinerary
    public Itinerary addItinerary ( Itinerary itinerary ) {
        return itineraries_Repositories.save(itinerary);
    }
    
}