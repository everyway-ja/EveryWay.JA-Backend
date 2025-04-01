package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.repositories.AccountCategories_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class AccountCategories_Service {

    @Autowired private AccountCategories_Repository accountCategories_Repository;

    public AccountCategory findById ( int id ) {
        return accountCategories_Repository.findById(id);
    }

    public List<AccountCategory> findByDescription ( String description ) {
        return accountCategories_Repository.findByDescription(description);
    }

    public List<AccountCategory> findAll () {
        return accountCategories_Repository.findAll();
    }

}