package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.AccountCategory_AccountId;
import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.AccountCategory_Account;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface AccountCategories_Accounts_Repository extends JpaRepository<AccountCategory_Account, AccountCategory_AccountId> {

    AccountCategory_Account findByAssociatedAccountCategoryAndAssociatedAccount(AccountCategory category, Account account);

    List<AccountCategory> findByAssociatedAccountCategory(AccountCategory category);
    List<Account> findByAssociatedAccount(Account account);

    @NonNull List<AccountCategory_Account> findAll();

}