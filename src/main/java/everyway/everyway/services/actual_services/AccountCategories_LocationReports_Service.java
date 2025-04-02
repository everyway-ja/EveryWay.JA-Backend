package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.AccountCategory_LocationReport;
import everyway.everyway.models.tables.LocationReport;
import everyway.everyway.repositories.AccountCategories_LocationReports_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountCategories_LocationReports_Service {

    @Autowired private AccountCategories_LocationReports_Repository accountCategories_LocationReports_Repository;

    /**
     * Finds an account category-location report association by the associated account category and associated location report.
     *
     * @param associatedAccountCategory the account category to search by
     * @param associatedLocationReport the location report to search by
     * @return the associated AccountCategory_LocationReport object if found, otherwise null
     */
    public AccountCategory_LocationReport findByAssociatedAccountCategoryAndAssociatedLocationReport ( AccountCategory associatedAccountCategory , LocationReport associatedLocationReport ) {
        return accountCategories_LocationReports_Repository.findByAssociatedAccountCategoryAndAssociatedLocationReport(associatedAccountCategory, associatedLocationReport);
    }

    /**
     * Finds all account category-location report associations for the specified account category.
     *
     * @param associatedAccountCategory the account category to search by
     * @return a list of AccountCategory_LocationReport objects associated with the given account category
     */
    public List<AccountCategory_LocationReport> findByAssociatedAccountCategory (AccountCategory associatedAccountCategory ) {
        return accountCategories_LocationReports_Repository.findByAssociatedAccountCategory(associatedAccountCategory);
    }

    /**
     * Finds all account category-location report associations for the specified location report.
     *
     * @param associatedLocationReport the location report to search by
     * @return a list of AccountCategory_LocationReport objects associated with the given location report
     */
    public List<AccountCategory_LocationReport> findByAssociatedLocationReport ( LocationReport associatedLocationReport ) {
        return accountCategories_LocationReports_Repository.findByAssociatedLocationReport(associatedLocationReport);
    }

    /**
     * Retrieves all account category-location report associations.
     *
     * @return a list of all AccountCategory_LocationReport associations
     */
    public List<AccountCategory_LocationReport> findAll () {
        return accountCategories_LocationReports_Repository.findAll();
    }
    
}