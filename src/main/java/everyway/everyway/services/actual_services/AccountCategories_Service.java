package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.repositories.AccountCategories_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class AccountCategories_Service {

    @Autowired private AccountCategories_Repository accountCategories_Repository;

    /**
     * Finds an account category by its unique identifier (ID).
     *
     * @param id the unique identifier of the account category
     * @return the AccountCategory object associated with the given ID, or null if not found
     */
    public AccountCategory findById ( int id ) {
        return accountCategories_Repository.findById(id);
    }

    /**
     * Finds all account categories that match the given description.
     *
     * @param description the description to search for
     * @return a list of AccountCategory objects matching the given description
     */
    public List<AccountCategory> findByDescription ( String description ) {
        return accountCategories_Repository.findByDescription(description);
    }

    /**
     * Retrieves all account categories.
     *
     * @return a list of all AccountCategory objects in the database
     */
    public List<AccountCategory> findAll () {
        return accountCategories_Repository.findAll();
    }
    
    // any other method for this specific object is useless: addition, deletion and update should be performed directly on the database

}