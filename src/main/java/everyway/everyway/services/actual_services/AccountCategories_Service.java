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
     * Retrieves an account category by its unique identifier.
     *
     * @param id The unique identifier of the account category.
     * @return AccountCategory - The AccountCategory object matching the given ID, or null if no match is found.
     */
    public AccountCategory findById ( int id ) {
        return accountCategories_Repository.findById(id);
    }

    /**
     * Retrieves all account categories with a specific description.
     *
     * @param description The description to filter account categories by.
     * @return List<AccountCategory> - A list of AccountCategory objects that match the specified description.
     */
    public List<AccountCategory> findByDescription ( String description ) {
        return accountCategories_Repository.findByDescription(description);
    }

    /**
     * Retrieves all account categories stored in the database.
     *
     * @return List<AccountCategory> - A list of all AccountCategory objects.
     */
    public List<AccountCategory> findAll () {
        return accountCategories_Repository.findAll();
    }
    
    // any other method for this specific object is useless: addition, deletion and update should be performed directly on the database

}