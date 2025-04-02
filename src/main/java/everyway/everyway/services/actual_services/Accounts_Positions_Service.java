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

    /**
     * Finds an Account_Position association based on the associated Account, Position, and creation timestamp.
     *
     * @param account the associated Account
     * @param position the associated Position
     * @param creation_timestamp the timestamp when the association was created
     * @return the Account_Position object that matches the given criteria, or null if not found
     */
    public Account_Position findByAssociatedAccountAndAssociatedPositionAndCreationTimestamp ( Account account , Position position , LocalDateTime creation_timestamp ) {
        return accounts_Positions_Repository.findByAssociatedAccountAndAssociatedPositionAndCreationTimestamp(account, position, creation_timestamp);
    }

    /**
     * Finds all Account_Position associations for a given Account.
     *
     * @param associatedAccount the Account to search for associated positions
     * @return a list of Account_Position objects associated with the given Account
     */
    public List<Account_Position> findByAssociatedAccount ( Account associatedAccount ) {
        return accounts_Positions_Repository.findByAssociatedAccount(associatedAccount);
    }

    /**
     * Finds all Account_Position associations for a given Position.
     *
     * @param associatedPosition the Position to search for associated accounts
     * @return a list of Account_Position objects associated with the given Position
     */
    public List<Account_Position> findByAssociatedPosition ( Position associatedPosition ) {
        return accounts_Positions_Repository.findByAssociatedPosition(associatedPosition);
    }

    /**
     * Retrieves all Account_Position associations from the database.
     *
     * @return a list of all Account_Position objects in the database
     */
    public List<Account_Position> findAll () {
        return accounts_Positions_Repository.findAll();
    }
    
}