package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.Account;
import packet.model.Language;
import java.util.Date;
import java.util.List;

@Repository
public interface Accounts_Repository extends JpaRepository<Account, Integer> {

    Account findByID(int ID);
    Account findByIDAndPassword(int ID, String password);

    List<Account> findByName(String name);
    List<Account> findBySurname(String surname);
    List<Account> findByUsername(String username);
    List<Account> findByEmail(String email);
    List<Account> findByBirthDate(Date birthDate);
    List<Account> findByAssociatedLanguage(Language languaage);

    List<Account> findByNameAndSurname(String name, String surname);

}