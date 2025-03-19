package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.AccountCategory_ItineraryId;
import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.AccountCategory_Itinerary;
import everyway.everyway.models.tables.Itinerary;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface AccountCategories_Itineraries_Repository extends JpaRepository<AccountCategory_Itinerary, AccountCategory_ItineraryId> {

    AccountCategory_Itinerary findByAssociatedAccountCategoryAndAssociatedItinerary(AccountCategory associatedAccountCategory, Itinerary associatedItinerary);

    List<AccountCategory_Itinerary> findByAssociatedAccountCategory(AccountCategory associatedAccountCategory);
    List<AccountCategory_Itinerary> findByAssociatedItinerary(Itinerary associatedItinerary);

    @NonNull List<AccountCategory_Itinerary> findAll();

}