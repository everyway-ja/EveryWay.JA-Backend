package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.tables.AccountCategory;
import packet.model.ids.AccountCategory_AccountId;
import java.util.List;
import packet.model.tables.Account;
import packet.model.tables.AccountCategory_Account;
import org.springframework.lang.NonNull;

@Repository

public interface AccountCategories_Accounts_Repository extends JpaRepository<AccountCategory_Account, AccountCategory_AccountId> {

    AccountCategory_Account findByAssociatedAccountCategoryAndAssociatedAccount(AccountCategory category, Account account);

    List<AccountCategory> findByAssociatedAccountCategory(AccountCategory category);
    List<Account> findByAssociatedAccount(Account account);

    @NonNull List<AccountCategory_Account> findAll();

}