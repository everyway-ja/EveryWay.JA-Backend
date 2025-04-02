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
     * Finds an Account by its ID.
     *
     * @param id the ID of the Account
     * @return the Account with the specified ID, or null if not found
     */
    public Account findById ( int id ) {
        return accounts_Repository.findById(id);
    }

    /**
     * Finds an Account by its ID and password.
     *
     * @param id the ID of the Account
     * @param password the password of the Account
     * @return the Account with the specified ID and password, or null if not found
     */
    public Account findByIdAndPassword ( int id , String password ) {
        return accounts_Repository.findByIdAndPassword(id, password);
    }

    /**
     * Finds all Accounts by the name of the Account holder.
     *
     * @param name the name of the Account holder
     * @return a list of Accounts with the specified name
     */
    public List<Account> findByName ( String name ) {
        return accounts_Repository.findByName(name);
    }

    /**
     * Finds all Accounts by the surname of the Account holder.
     *
     * @param surname the surname of the Account holder
     * @return a list of Accounts with the specified surname
     */
    public List<Account> findBySurname ( String surname ) {
        return accounts_Repository.findBySurname(surname);
    }

    /**
     * Finds all Accounts by the username.
     *
     * @param username the username associated with the Account
     * @return a list of Accounts with the specified username
     */
    public List<Account> findByUsername ( String username ) {
        return accounts_Repository.findByUsername(username);
    }

    /**
     * Finds all Accounts by the email address.
     *
     * @param email the email address associated with the Account
     * @return a list of Accounts with the specified email address
     */
    public List<Account> findByEmail ( String email ) {
        return accounts_Repository.findByEmail(email);
    }

    /**
     * Finds all Accounts by the birth date.
     *
     * @param birthDate the birth date of the Account holder
     * @return a list of Accounts with the specified birth date
     */
    public List<Account> findByBirthDate ( Date birthDate ) {
        return accounts_Repository.findByBirthDate(birthDate);
    }

    /**
     * Finds all Accounts associated with a specific Language.
     *
     * @param language the Language associated with the Account
     * @return a list of Accounts associated with the specified Language
     */
    public List<Account> findByAssociatedLanguage ( Language language ) {
        return accounts_Repository.findByAssociatedLanguage(language);
    }

    /**
     * Finds all Accounts by both the name and surname of the Account holder.
     *
     * @param name the name of the Account holder
     * @param surname the surname of the Account holder
     * @return a list of Accounts with the specified name and surname
     */
    public List<Account> findByNameAndSurname ( String name, String surname ) {
        return accounts_Repository.findByNameAndSurname(name, surname);
    }

    /**
     * Retrieves all Accounts from the repository.
     *
     * @return a list of all Accounts in the repository
     */
    public List<Account> findAll () {
        return accounts_Repository.findAll();
    }

    /**
     * Adds a new Account to the repository.
     *
     * @param account the Account to be added
     */
    public void addAccount ( Account account ) {
        accounts_Repository.save(account);
    }
    
}