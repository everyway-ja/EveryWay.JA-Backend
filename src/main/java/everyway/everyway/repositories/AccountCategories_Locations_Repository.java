package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.AccountCategory_LocationId;
import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.AccountCategory_Location;
import everyway.everyway.models.tables.Location;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface AccountCategories_Locations_Repository extends JpaRepository<AccountCategory_Location, AccountCategory_LocationId> {

    AccountCategory_Location findByAssociatedAccountCategoryAndAssociatedLocation(AccountCategory associatedAccountCategory, Location associatedLocation);

    List<AccountCategory_Location> findByAssociatedAccountCategory(AccountCategory associatedAccountCategory);
    List<AccountCategory_Location> findByAssociatedLocation(Location associatedLocation);
    
    @NonNull List<AccountCategory_Location> findAll();

}