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

    public AccountCategory_LocationReport findByAssociatedAccountCategoryAndAssociatedLocationReport ( AccountCategory associatedAccountCategory , LocationReport associatedLocationReport ) {
        return accountCategories_LocationReports_Repository.findByAssociatedAccountCategoryAndAssociatedLocationReport(associatedAccountCategory, associatedLocationReport);
    }

    public List<AccountCategory_LocationReport> findByAssociatedAccountCategory (AccountCategory associatedAccountCategory ) {
        return accountCategories_LocationReports_Repository.findByAssociatedAccountCategory(associatedAccountCategory);
    }

    public List<AccountCategory_LocationReport> findByAssociatedLocationReport ( LocationReport associatedLocationReport ) {
        return accountCategories_LocationReports_Repository.findByAssociatedLocationReport(associatedLocationReport);
    }

    public List<AccountCategory_LocationReport> findAll () {
        return accountCategories_LocationReports_Repository.findAll();
    }
    
}