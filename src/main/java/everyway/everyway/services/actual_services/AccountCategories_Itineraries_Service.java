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

    /**
     * Finds an account category-itinerary association by the associated account category and associated itinerary.
     *
     * @param associatedAccountCategory the account category to search by
     * @param associatedItinerary the itinerary to search by
     * @return the associated AccountCategory_Itinerary object if found, otherwise null
     */
    public AccountCategory_Itinerary findByAssociatedAccountCategoryAndAssociatedItinerary ( AccountCategory associatedAccountCategory , Itinerary associatedItinerary ) {
        return accountCategories_Itineraries_Repository.findByAssociatedAccountCategoryAndAssociatedItinerary(associatedAccountCategory, associatedItinerary);
    }

    /**
     * Finds all account category-itinerary associations for the specified account category.
     *
     * @param associatedAccountCategory the account category to search by
     * @return a list of AccountCategory_Itinerary objects associated with the given account category
     */
    public List<AccountCategory_Itinerary> findByAssociatedAccountCategory ( AccountCategory associatedAccountCategory ) {
        return accountCategories_Itineraries_Repository.findByAssociatedAccountCategory(associatedAccountCategory);
    }

    /**
     * Finds all account category-itinerary associations for the specified itinerary.
     *
     * @param associatedItinerary the itinerary to search by
     * @return a list of AccountCategory_Itinerary objects associated with the given itinerary
     */
    public List<AccountCategory_Itinerary> findByAssociatedItinerary ( Itinerary associatedItinerary ) {
        return accountCategories_Itineraries_Repository.findByAssociatedItinerary(associatedItinerary);
    }

    /**
     * Finds all account category-itinerary associations for the specified itinerary.
     *
     * @param associatedItinerary the itinerary to search by
     * @return a list of AccountCategory_Itinerary objects associated with the given itinerary
     */
    public List<AccountCategory_Itinerary> findAll () {
        return accountCategories_Itineraries_Repository.findAll();
    }



    // add a new association between an account category and an itinerary
    public void addAssociation ( AccountCategory_Itinerary accountCategory_Itinerary ) {
        accountCategories_Itineraries_Repository.save(accountCategory_Itinerary);
    } 
    
}