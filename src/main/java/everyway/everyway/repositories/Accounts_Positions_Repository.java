package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.Account_PositionId;
import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Account_Position;
import everyway.everyway.models.tables.Position;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface Accounts_Positions_Repository extends JpaRepository<Account_Position, Account_PositionId> {

    Account_Position findByAssociatedAccountAndAssociatedPositionAndCreationTimestamp(Account account, Position position, LocalDateTime creation_timestamp);

    List<Account_Position> findByAssociatedAccount(Account associatedAccount);
    List<Account_Position> findByAssociatedPosition(Position associatedPosition);

    @NonNull List<Account_Position> findAll();

}