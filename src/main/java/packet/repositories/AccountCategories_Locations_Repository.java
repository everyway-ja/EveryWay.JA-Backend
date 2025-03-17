package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.AccountCategory_LocationId;
import packet.model.tables.AccountCategory;
import packet.model.tables.AccountCategory_Location;
import packet.model.tables.Location;
import java.util.List;

@Repository

public interface AccountCategories_Locations_Repository extends JpaRepository<AccountCategory_Location, AccountCategory_LocationId> {

    AccountCategory_Location findByAssociatedAccountCategoryAndAssociatedLocation(AccountCategory associatedAccountCategory, Location associatedLocation);

    List<AccountCategory_Location> findByAssociatedAccountCategory(AccountCategory associatedAccountCategory);
    List<AccountCategory_Location> findByAssociatedLocation(Location associatedLocation);
    
}