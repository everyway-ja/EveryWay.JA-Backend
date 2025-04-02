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
     * Finds an AccountCategory_Itinerary association by the associated account category and itinerary.
     *
     * @param associatedAccountCategory The AccountCategory object to filter by.
     * @param associatedItinerary The Itinerary object to filter by.
     * @return AccountCategory_Itinerary - The association matching the given account category and itinerary, or null if no match is found.
     */
    public AccountCategory_Itinerary findByAssociatedAccountCategoryAndAssociatedItinerary ( AccountCategory associatedAccountCategory , Itinerary associatedItinerary ) {
        return accountCategories_Itineraries_Repository.findByAssociatedAccountCategoryAndAssociatedItinerary(associatedAccountCategory, associatedItinerary);
    }

    /**
     * Retrieves all AccountCategory_Itinerary associations for a specific account category.
     *
     * @param associatedAccountCategory The AccountCategory object to filter by.
     * @return List<AccountCategory_Itinerary> - A list of AccountCategory_Itinerary associations linked to the specified account category.
     */
    public List<AccountCategory_Itinerary> findByAssociatedAccountCategory ( AccountCategory associatedAccountCategory ) {
        return accountCategories_Itineraries_Repository.findByAssociatedAccountCategory(associatedAccountCategory);
    }

    /**
     * Retrieves all AccountCategory_Itinerary associations for a specific itinerary.
     *
     * @param associatedItinerary The Itinerary object to filter by.
     * @return List<AccountCategory_Itinerary> - A list of AccountCategory_Itinerary associations linked to the specified itinerary.
     */
    public List<AccountCategory_Itinerary> findByAssociatedItinerary ( Itinerary associatedItinerary ) {
        return accountCategories_Itineraries_Repository.findByAssociatedItinerary(associatedItinerary);
    }

    /**
     * Retrieves all AccountCategory_Itinerary associations stored in the database.
     *
     * @return List<AccountCategory_Itinerary> - A list of all AccountCategory_Itinerary associations.
     */
    public List<AccountCategory_Itinerary> findAll () {
        return accountCategories_Itineraries_Repository.findAll();
    }

    /**
     * Adds a new AccountCategory_Itinerary association to the database.
     *
     * @param accountCategory_Itinerary The AccountCategory_Itinerary object to be added.
     */
    public void addAssociation ( AccountCategory_Itinerary accountCategory_Itinerary ) {
        accountCategories_Itineraries_Repository.save(accountCategory_Itinerary);
    } 
    
}