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

    public AccountCategory_Account findByAssociatedAccountCategoryAndAssociatedAccount ( AccountCategory category , Account account ) {
        return accountCategories_Accounts_Repository.findByAssociatedAccountCategoryAndAssociatedAccount(category, account);
    }

    public List<AccountCategory> findByAssociatedAccountCategory ( AccountCategory category ) {
        return accountCategories_Accounts_Repository.findByAssociatedAccountCategory(category);
    }

    public List<Account> findByAssociatedAccount ( Account account ) {
        return accountCategories_Accounts_Repository.findByAssociatedAccount(account);
    }

    public List<AccountCategory_Account> findAll () {
        return accountCategories_Accounts_Repository.findAll();
    }



    // add new account category - account
    public void addAssociation ( AccountCategory_Account accountCategory_Account ) {
        accountCategories_Accounts_Repository.save(accountCategory_Account);
    }

}