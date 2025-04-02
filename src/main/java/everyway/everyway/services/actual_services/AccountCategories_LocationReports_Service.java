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
     * Finds an AccountCategory_LocationReport association by the associated account category and location report.
     *
     * @param associatedAccountCategory The AccountCategory object to filter by.
     * @param associatedLocationReport The LocationReport object to filter by.
     * @return AccountCategory_LocationReport - The association matching the given account category and location report, or null if no match is found.
     */
    public AccountCategory_LocationReport findByAssociatedAccountCategoryAndAssociatedLocationReport ( AccountCategory associatedAccountCategory , LocationReport associatedLocationReport ) {
        return accountCategories_LocationReports_Repository.findByAssociatedAccountCategoryAndAssociatedLocationReport(associatedAccountCategory, associatedLocationReport);
    }

    /**
     * Retrieves all AccountCategory_LocationReport associations for a specific account category.
     *
     * @param associatedAccountCategory The AccountCategory object to filter by.
     * @return List<AccountCategory_LocationReport> - A list of AccountCategory_LocationReport associations linked to the specified account category.
     */
    public List<AccountCategory_LocationReport> findByAssociatedAccountCategory ( AccountCategory associatedAccountCategory ) {
        return accountCategories_LocationReports_Repository.findByAssociatedAccountCategory(associatedAccountCategory);
    }

    /**
     * Retrieves all AccountCategory_LocationReport associations for a specific location report.
     *
     * @param associatedLocationReport The LocationReport object to filter by.
     * @return List<AccountCategory_LocationReport> - A list of AccountCategory_LocationReport associations linked to the specified location report.
     */
    public List<AccountCategory_LocationReport> findByAssociatedLocationReport ( LocationReport associatedLocationReport ) {
        return accountCategories_LocationReports_Repository.findByAssociatedLocationReport(associatedLocationReport);
    }

    /**
     * Retrieves all AccountCategory_LocationReport associations stored in the database.
     *
     * @return List<AccountCategory_LocationReport> - A list of all AccountCategory_LocationReport associations.
     */
    public List<AccountCategory_LocationReport> findAll () {
        return accountCategories_LocationReports_Repository.findAll();
    }
    
}