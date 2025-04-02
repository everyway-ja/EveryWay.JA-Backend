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
     * Finds an Account_Position association by the associated account, position, and creation timestamp.
     *
     * @param account The Account object to filter by.
     * @param position The Position object to filter by.
     * @param creation_timestamp The timestamp to filter by.
     * @return Account_Position - The association matching the given account, position, and timestamp, or null if no match is found.
     */
    public Account_Position findByAssociatedAccountAndAssociatedPositionAndCreationTimestamp ( Account account , Position position , LocalDateTime creation_timestamp ) {
        return accounts_Positions_Repository.findByAssociatedAccountAndAssociatedPositionAndCreationTimestamp(account, position, creation_timestamp);
    }

    /**
     * Retrieves all Account_Position associations for a specific account.
     *
     * @param associatedAccount The Account object to filter by.
     * @return List<Account_Position> - A list of Account_Positions associations linked to the specified account.
     */
    public List<Account_Position> findByAssociatedAccount ( Account associatedAccount ) {
        return accounts_Positions_Repository.findByAssociatedAccount(associatedAccount);
    }

    /**
     * Retrieves all Account_Position associations for a specific position.
     *
     * @param associatedPosition The Position object to filter by.
     * @return List<Account_Position> - A list of Account_Position associations linked to the specified position.
     */
    public List<Account_Position> findByAssociatedPosition ( Position associatedPosition ) {
        return accounts_Positions_Repository.findByAssociatedPosition(associatedPosition);
    }

    /**
     * Retrieves all Account_Position associations stored in the database.
     *
     * @return List<Account_Position> - A list of all Account_Position associations.
     */
    public List<Account_Position> findAll () {
        return accounts_Positions_Repository.findAll();
    }
    
}