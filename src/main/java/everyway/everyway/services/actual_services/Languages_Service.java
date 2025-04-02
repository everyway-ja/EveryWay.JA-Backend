package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Language;
import everyway.everyway.repositories.Languages_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Languages_Service {

    @Autowired private Languages_Repository languages_Repository;

    /**
     * Retrieves a language by its ID.
     * 
     * This method queries the repository to find a language with the specified ID.
     * 
     * @param id the ID of the language
     * @return the language with the specified ID, or null if not found
     */
    public Language findById ( int id ) {
        return languages_Repository.findById(id);
    }

    /**
     * Retrieves a list of languages that match the given short description.
     * 
     * This method queries the repository to find all languages with the specified short description.
     * 
     * @param shortDescription the short description to match against
     * @return a list of languages that match the short description
     */
    public List<Language> findByShortDescription ( String shortDescription ) {
        return languages_Repository.findByShortDescription(shortDescription);
    }

    /**
     * Retrieves a list of languages that match the given long description.
     * 
     * This method queries the repository to find all languages with the specified long description.
     * 
     * @param longDescription the long description to match against
     * @return a list of languages that match the long description
     */
    public List<Language> findByLongDescription ( String longDescription ) {
        return languages_Repository.findByLongDescription(longDescription);
    }

    /**
     * Retrieves a list of all languages.
     * 
     * This method queries the repository to return all the available languages.
     * 
     * @return a list of all languages
     */
    public List<Language> findAll () {
        return languages_Repository.findAll();
    }
    
    // any other method for this specific object is useless: addition, deletion and update should be performed directly on the database
    
}