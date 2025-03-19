package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Language;
import java.util.Date;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface Accounts_Repository extends JpaRepository<Account, Integer> {

    Account findById(int id);
    Account findByIdAndPassword(int id, String password);

    List<Account> findByName(String name);
    List<Account> findBySurname(String surname);
    List<Account> findByUsername(String username);
    List<Account> findByEmail(String email);
    List<Account> findByBirthDate(Date birthDate);
    List<Account> findByAssociatedLanguage(Language languaage);

    List<Account> findByNameAndSurname(String name, String surname);

    @NonNull List<Account> findAll();

}