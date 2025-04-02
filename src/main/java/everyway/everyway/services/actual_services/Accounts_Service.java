package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Language;
import everyway.everyway.repositories.Accounts_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service

public class Accounts_Service {

    @Autowired private Accounts_Repository accounts_Repository;

    /**
     * Retrieves an account by its unique identifier.
     *
     * @param id The unique identifier of the account.
     * @return Account - The Account object matching the given ID, or null if no match is found.
     */
    public Account findById ( int id ) {
        return accounts_Repository.findById(id);
    }

    /**
     * Retrieves an account by its unique identifier and password.
     *
     * @param id The unique identifier of the account.
     * @param password The password of the account.
     * @return Account - The Account object matching the given ID and password, or null if no match is found.
     */
    public Account findByIdAndPassword ( int id , String password ) {
        return accounts_Repository.findByIdAndPassword(id, password);
    }

    /**
     * Retrieves all accounts with a specific name.
     *
     * @param name The name to filter accounts by.
     * @return List<Account> - A list of Account objects that match the specified name.
     */
    public List<Account> findByName ( String name ) {
        return accounts_Repository.findByName(name);
    }

    /**
     * Retrieves all accounts with a specific surname.
     *
     * @param surname The surname to filter accounts by.
     * @return List<Account> - A list of Account objects that match the specified surname.
     */
    public List<Account> findBySurname ( String surname ) {
        return accounts_Repository.findBySurname(surname);
    }

    /**
     * Retrieves all accounts with a specific username.
     *
     * @param username The username to filter accounts by.
     * @return List<Account> - A list of Account objects that match the specified username.
     */
    public List<Account> findByUsername ( String username ) {
        return accounts_Repository.findByUsername(username);
    }

    /**
     * Retrieves all accounts with a specific email address.
     *
     * @param email The email address to filter accounts by.
     * @return List<Account> - A list of Account objects that match the specified email address.
     */
    public List<Account> findByEmail ( String email ) {
        return accounts_Repository.findByEmail(email);
    }

    /**
     * Retrieves all accounts with a specific birth date.
     *
     * @param birthDate The birth date to filter accounts by.
     * @return List<Account> - A list of Account objects that match the specified birth date.
     */
    public List<Account> findByBirthDate ( Date birthDate ) {
        return accounts_Repository.findByBirthDate(birthDate);
    }

    /**
     * Retrieves all accounts associated with a specific language.
     *
     * @param language The Language object to filter accounts by.
     * @return List<Account> - A list of Account objects linked to the specified language.
     */
    public List<Account> findByAssociatedLanguage ( Language language ) {
        return accounts_Repository.findByAssociatedLanguage(language);
    }

    /**
     * Retrieves all accounts with a specific name and surname.
     *
     * @param name The name to filter accounts by.
     * @param surname The surname to filter accounts by.
     * @return List<Account> - A list of Account objects that match the specified name and surname.
     */
    public List<Account> findByNameAndSurname ( String name, String surname ) {
        return accounts_Repository.findByNameAndSurname(name, surname);
    }

    /**
     * Retrieves all accounts stored in the database.
     *
     * @return List<Account> - A list of all Account objects.
     */
    public List<Account> findAll () {
        return accounts_Repository.findAll();
    }

    /**
     * Adds a new account to the database.
     *
     * @param account The Account object to be added.
     */
    public void addAccount ( Account account ) {
        accounts_Repository.save(account);
    }
    
}