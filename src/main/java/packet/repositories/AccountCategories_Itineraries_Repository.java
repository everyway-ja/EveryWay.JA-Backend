package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.AccountCategory_ItineraryId;
import packet.model.tables.*;
import java.util.List;

@Repository

public interface AccountCategories_Itineraries_Repository extends JpaRepository<AccountCategory_Itinerary, AccountCategory_ItineraryId> {

    AccountCategory_Itinerary findByAssociatedAccountCategoryAndAssociatedItinerary(AccountCategory associatedAccountCategory, Itinerary associatedItinerary);

    List<AccountCategory_Itinerary> findByAssociatedAccountCategory(AccountCategory associatedAccountCategory);
    List<AccountCategory_Itinerary> findByAssociatedItinerary(Itinerary associatedItinerary);

}