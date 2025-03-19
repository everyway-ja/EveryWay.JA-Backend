package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.AccountCategory_LocationReportId;
import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.AccountCategory_LocationReport;
import everyway.everyway.models.tables.LocationReport;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface AccountCategories_LocationReports_Repository extends JpaRepository<AccountCategory_LocationReport, AccountCategory_LocationReportId> {

    AccountCategory_LocationReport findByAssociatedAccountCategoryAndAssociatedLocationReport(AccountCategory associatedAccountCategory, LocationReport associatedLocationReport);

    List<AccountCategory_LocationReport> findByAssociatedAccountCategory(AccountCategory associatedAccountCategory);
    List<AccountCategory_LocationReport> findByAssociatedLocationReport(LocationReport associatedLocationReport);

    @NonNull List<AccountCategory_LocationReport> findAll();

}