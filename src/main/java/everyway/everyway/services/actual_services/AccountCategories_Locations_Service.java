package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.AccountCategory_Location;
import everyway.everyway.models.tables.Location;
import everyway.everyway.repositories.AccountCategories_Locations_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class AccountCategories_Locations_Service {

    @Autowired private AccountCategories_Locations_Repository accountCategories_Locations_Repository;

    public AccountCategory_Location findByAssociatedAccountCategoryAndAssociatedLocation ( AccountCategory associatedAccountCategory , Location associatedLocation ) {
        return accountCategories_Locations_Repository.findByAssociatedAccountCategoryAndAssociatedLocation(associatedAccountCategory, associatedLocation);
    }

    public List<AccountCategory_Location> findByAssociatedAccountCategory ( AccountCategory associatedAccountCategory ) {
        return accountCategories_Locations_Repository.findByAssociatedAccountCategory(associatedAccountCategory);
    }

    public List<AccountCategory_Location> findByAssociatedLocation ( Location associatedLocation ) {
        return accountCategories_Locations_Repository.findByAssociatedLocation(associatedLocation);
    }

    public List<AccountCategory_Location> findAll () {
        return accountCategories_Locations_Repository.findAll();
    }

}