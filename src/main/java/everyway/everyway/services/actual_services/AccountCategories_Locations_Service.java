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

    /**
     * Finds an account category-location association by the associated account category and associated location.
     *
     * @param associatedAccountCategory the account category to search by
     * @param associatedLocation the location to search by
     * @return the associated AccountCategory_Location object if found, otherwise null
     */
    public AccountCategory_Location findByAssociatedAccountCategoryAndAssociatedLocation ( AccountCategory associatedAccountCategory , Location associatedLocation ) {
        return accountCategories_Locations_Repository.findByAssociatedAccountCategoryAndAssociatedLocation(associatedAccountCategory, associatedLocation);
    }

    /**
     * Finds all account category-location associations for the specified account category.
     *
     * @param associatedAccountCategory the account category to search by
     * @return a list of AccountCategory_Location objects associated with the given account category
     */
    public List<AccountCategory_Location> findByAssociatedAccountCategory ( AccountCategory associatedAccountCategory ) {
        return accountCategories_Locations_Repository.findByAssociatedAccountCategory(associatedAccountCategory);
    }

    /**
     * Finds all account category-location associations for the specified location.
     *
     * @param associatedLocation the location to search by
     * @return a list of AccountCategory_Location objects associated with the given location
     */
    public List<AccountCategory_Location> findByAssociatedLocation ( Location associatedLocation ) {
        return accountCategories_Locations_Repository.findByAssociatedLocation(associatedLocation);
    }

    /**
     * Retrieves all account category-location associations.
     *
     * @return a list of all AccountCategory_Location associations
     */
    public List<AccountCategory_Location> findAll () {
        return accountCategories_Locations_Repository.findAll();
    }

}