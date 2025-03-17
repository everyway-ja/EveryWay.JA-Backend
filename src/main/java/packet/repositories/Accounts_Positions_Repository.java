package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.AccountCategory_LocationReportId;
import packet.model.ids.Account_PositionId;
import packet.model.tables.*;

@Repository
public interface Accounts_Positions_Repository extends JpaRepository<Account_Position, Account_PositionId> {

    Account_Position findByAssociatedAccountAndAssociatedPosition(Account associatedAccount, Position associatedPosition);

    Account_Position findByAssociatedAccount(Account associatedAccount);
    Account_Position findByAssociatedPosition(Position associatedPosition);
}