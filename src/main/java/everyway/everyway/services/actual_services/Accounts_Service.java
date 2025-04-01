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

    public Account findById ( int id ) {
        return accounts_Repository.findById(id);
    }

    public Account findByIdAndPassword ( int id , String password ) {
        return accounts_Repository.findByIdAndPassword(id, password);
    }

    public List<Account> findByName ( String name ) {
        return accounts_Repository.findByName(name);
    }

    public List<Account> findBySurname ( String surname ) {
        return accounts_Repository.findBySurname(surname);
    }

    public List<Account> findByUsername ( String username ) {
        return accounts_Repository.findByUsername(username);
    }

    public List<Account> findByEmail ( String email ) {
        return accounts_Repository.findByEmail(email);
    }

    public List<Account> findByBirthDate ( Date birthDate ) {
        return accounts_Repository.findByBirthDate(birthDate);
    }

    public List<Account> findByAssociatedLanguage ( Language language ) {
        return accounts_Repository.findByAssociatedLanguage(language);
    }

    public List<Account> findByNameAndSurname ( String name, String surname ) {
        return accounts_Repository.findByNameAndSurname(name, surname);
    }

    public List<Account> findAll () {
        return accounts_Repository.findAll();
    }
}