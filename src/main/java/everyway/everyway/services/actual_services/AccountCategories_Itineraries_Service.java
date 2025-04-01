package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.AccountCategory_Itinerary;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.repositories.AccountCategories_Itineraries_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class AccountCategories_Itineraries_Service {

    @Autowired private AccountCategories_Itineraries_Repository accountCategories_Itineraries_Repository;

    public AccountCategory_Itinerary findByAssociatedAccountCategoryAndAssociatedItinerary ( AccountCategory associatedAccountCategory , Itinerary associatedItinerary ) {
        return accountCategories_Itineraries_Repository.findByAssociatedAccountCategoryAndAssociatedItinerary(associatedAccountCategory, associatedItinerary);
    }

    public List<AccountCategory_Itinerary> findByAssociatedAccountCategory ( AccountCategory associatedAccountCategory ) {
        return accountCategories_Itineraries_Repository.findByAssociatedAccountCategory(associatedAccountCategory);
    }

    public List<AccountCategory_Itinerary> findByAssociatedItinerary ( Itinerary associatedItinerary ) {
        return accountCategories_Itineraries_Repository.findByAssociatedItinerary(associatedItinerary);
    }

    public List<AccountCategory_Itinerary> findAll () {
        return accountCategories_Itineraries_Repository.findAll();
    }
    
}