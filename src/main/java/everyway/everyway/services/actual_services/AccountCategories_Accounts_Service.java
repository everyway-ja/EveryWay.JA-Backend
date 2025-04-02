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
     * Finds an AccountCategory_Account association by the associated account category and account.
     *
     * @param category The AccountCategory object to filter by.
     * @param account The Account object to filter by.
     * @return AccountCategory_Account - The association matching the given account category and account, or null if no match is found.
     */
    public AccountCategory_Account findByAssociatedAccountCategoryAndAssociatedAccount ( AccountCategory category , Account account ) {
        return accountCategories_Accounts_Repository.findByAssociatedAccountCategoryAndAssociatedAccount(category, account);
    }

    /**
     * Retrieves all AccountCategory_Account associations for a specific account category.
     *
     * @param category The AccountCategory object to filter by.
     * @return List<AccountCategory> - A list of AccountCategory_Account associations linked to the specified account category.
     */
    public List<AccountCategory> findByAssociatedAccountCategory ( AccountCategory category ) {
        return accountCategories_Accounts_Repository.findByAssociatedAccountCategory(category);
    }

    /**
     * Retrieves all AccountCategory_Account associations for a specific account.
     *
     * @param account The Account object to filter by.
     * @return List<Account> - A list of AccountCategory_Account associations linked to the specified account.
     */
    public List<Account> findByAssociatedAccount ( Account account ) {
        return accountCategories_Accounts_Repository.findByAssociatedAccount(account);
    }

    /**
     * Retrieves all AccountCategory_Account associations stored in the database.
     *
     * @return List<AccountCategory_Account> - A list of all AccountCategory_Account associations.
     */
    public List<AccountCategory_Account> findAll () {
        return accountCategories_Accounts_Repository.findAll();
    }

    /**
     * Adds a new AccountCategory_Account association to the database.
     *
     * @param accountCategory_Account The AccountCategory_Account object to be added.
     */
    public void addAssociation ( AccountCategory_Account accountCategory_Account ) {
        accountCategories_Accounts_Repository.save(accountCategory_Account);
    }

}