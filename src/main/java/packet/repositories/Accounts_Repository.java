package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import packet.model.tables.Account;
import packet.model.tables.Language;

import java.util.Date;
import java.util.List;

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

}