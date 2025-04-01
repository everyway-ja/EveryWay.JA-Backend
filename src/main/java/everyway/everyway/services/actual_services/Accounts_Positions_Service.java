package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Account_Position;
import everyway.everyway.models.tables.Position;
import everyway.everyway.repositories.Accounts_Positions_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class Accounts_Positions_Service {

    @Autowired private Accounts_Positions_Repository accounts_Positions_Repository;

    public Account_Position findByAssociatedAccountAndAssociatedPositionAndCreationTimestamp ( Account account , Position position , LocalDateTime creation_timestamp ) {
        return accounts_Positions_Repository.findByAssociatedAccountAndAssociatedPositionAndCreationTimestamp(account, position, creation_timestamp);
    }

    public List<Account_Position> findByAssociatedAccount ( Account associatedAccount ) {
        return accounts_Positions_Repository.findByAssociatedAccount(associatedAccount);
    }

    public List<Account_Position> findByAssociatedPosition ( Position associatedPosition ) {
        return accounts_Positions_Repository.findByAssociatedPosition(associatedPosition);
    }

    public List<Account_Position> findAll () {
        return accounts_Positions_Repository.findAll();
    }
    
}