package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import packet.model.Account;
import java.util.Date;
import java.util.List;

public interface Accounts_Repository extends JpaRepository<Account, Integer> {

    Account findByID(int ID);
    Account findByIDAndPassword(int ID, String password);

    List<Account> findByName(String name);
    List<Account> findBySurname(String surname);
    List<Account> findByUsername(String username);
    List<Account> findByEmail(String email);
    List<Account> findByBirthDate(Date birthDate);
    List<Account> findByAssociatedLanguage(int languageID);
    List<Account> findByCreation_timestamp(Date creation_timestamp);
    List<Account> findByUpdate_timestamp(Date update_timestamp);
    List<Account> findByDeletion_timestamp(Date deletion_timestamp);

    List<Account> findByNameAndSurname(String name, String surname);
    
    List<Account> findByCreation_timestampAfter(Date creation_timestamp);
    List<Account> findByCreation_timestampBefore(Date creation_timestamp);
    List<Account> findByCreation_timestampBetween(Date creation_timestamp1, Date creation_timestamp2);
    
    List<Account> findByUpdate_timestampAfter(Date update_timestamp);
    List<Account> findByUpdate_timestampBefore(Date update_timestamp);
    List<Account> findByUpdate_timestampBetween(Date update_timestamp1, Date update_timestamp2);

    List<Account> findByDeletion_timestampAfter(Date deletion_timestamp);
    List<Account> findByDeletion_timestampBefore(Date deletion_timestamp);
    List<Account> findByDeletion_timestampBetween(Date deletion_timestamp1, Date deletion_timestamp2);

}