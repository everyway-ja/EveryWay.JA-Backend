package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.AccountCategory_Account;
import everyway.everyway.repositories.AccountCategories_Accounts_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class AccountCategories_Accounts_Service {

    @Autowired private AccountCategories_Accounts_Repository accountCategories_Accounts_Repository;

    /**
     * Finds an account-category association by the associated account category and associated account.
     *
     * @param category the account category to search by
     * @param account the account to search by
     * @return the associated AccountCategory_Account object if found, otherwise null
     */
    public AccountCategory_Account findByAssociatedAccountCategoryAndAssociatedAccount ( AccountCategory category , Account account ) {
        return accountCategories_Accounts_Repository.findByAssociatedAccountCategoryAndAssociatedAccount(category, account);
    }

    /**
     * Finds all account categories associated with the specified account category.
     *
     * @param category the account category to search by
     * @return a list of AccountCategory objects associated with the given category
     */
    public List<AccountCategory> findByAssociatedAccountCategory ( AccountCategory category ) {
        return accountCategories_Accounts_Repository.findByAssociatedAccountCategory(category);
    }

    /**
     * Finds all accounts associated with the specified account.
     *
     * @param account the account to search by
     * @return a list of Account objects associated with the given account
     */
    public List<Account> findByAssociatedAccount ( Account account ) {
        return accountCategories_Accounts_Repository.findByAssociatedAccount(account);
    }

    /**
     * Retrieves all account-category associations.
     *
     * @return a list of all AccountCategory_Account associations
     */
    public List<AccountCategory_Account> findAll () {
        return accountCategories_Accounts_Repository.findAll();
    }

    /**
     * Adds a new account-category association to the repository.
     *
     * @param accountCategory_Account the AccountCategory_Account object to be added
     */
    // add new account category - account
    public void addAssociation ( AccountCategory_Account accountCategory_Account ) {
        accountCategories_Accounts_Repository.save(accountCategory_Account);
    }

}