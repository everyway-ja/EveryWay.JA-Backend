package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.AccountCategory_LocationReportId;
import packet.model.tables.*;
        import java.util.List;

@Repository
public interface AccountCategories_LocationReports_Repository extends JpaRepository<AccountCategory_LocationReport, AccountCategory_LocationReportId> {

    AccountCategory_LocationReport findByAssociatedAccountCategoryAndAssociatedLocationReport(AccountCategory associatedAccountCategory, LocationReport associatedLocationReport);

    List<AccountCategory_LocationReport> findByAssociatedAccountCategory(AccountCategory associatedAccountCategory);
    List<AccountCategory_LocationReport> findByAssociatedLocationReport(LocationReport associatedLocationReport);
}