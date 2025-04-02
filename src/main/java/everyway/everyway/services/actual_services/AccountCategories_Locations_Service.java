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
     * Finds an AccountCategory_Location association by the associated account category and location.
     *
     * @param associatedAccountCategory The AccountCategory object to filter by.
     * @param associatedLocation The Location object to filter by.
     * @return AccountCategory_Location - The association matching the given account category and location, or null if no match is found.
     */
    public AccountCategory_Location findByAssociatedAccountCategoryAndAssociatedLocation ( AccountCategory associatedAccountCategory , Location associatedLocation ) {
        return accountCategories_Locations_Repository.findByAssociatedAccountCategoryAndAssociatedLocation(associatedAccountCategory, associatedLocation);
    }

    /**
     * Retrieves all AccountCategory_Location associations for a specific account category.
     *
     * @param associatedAccountCategory The AccountCategory object to filter by.
     * @return List<AccountCategory_Location> - A list of AccountCategory_Location associations linked to the specified account category.
     */
    public List<AccountCategory_Location> findByAssociatedAccountCategory ( AccountCategory associatedAccountCategory ) {
        return accountCategories_Locations_Repository.findByAssociatedAccountCategory(associatedAccountCategory);
    }

    /**
     * Retrieves all AccountCategory_Location associations for a specific location.
     *
     * @param associatedLocation The Location object to filter by.
     * @return List<AccountCategory_Location> - A list of AccountCategory_Location associations linked to the specified location.
     */
    public List<AccountCategory_Location> findByAssociatedLocation ( Location associatedLocation ) {
        return accountCategories_Locations_Repository.findByAssociatedLocation(associatedLocation);
    }

    /**
     * Retrieves all AccountCategory_Location associations stored in the database.
     *
     * @return List<AccountCategory_Location> - A list of all AccountCategory_Location associations.
     */
    public List<AccountCategory_Location> findAll () {
        return accountCategories_Locations_Repository.findAll();
    }

}