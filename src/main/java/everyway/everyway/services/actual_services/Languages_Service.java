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
     * Retrieves a language by its unique identifier.
     *
     * @param id The unique identifier of the language.
     * @return Language - The Language object matching the given ID, or null if no match is found.
     */
    public Language findById ( int id ) {
        return languages_Repository.findById(id);
    }

    /**
     * Retrieves all languages with a specific short description.
     *
     * @param shortDescription The short description to filter languages by.
     * @return List<Language> - A list of Language objects that match the specified short description.
     */
    public List<Language> findByShortDescription ( String shortDescription ) {
        return languages_Repository.findByShortDescription(shortDescription);
    }

    /**
     * Retrieves all languages with a specific long description.
     *
     * @param longDescription The long description to filter languages by.
     * @return List<Language> - A list of Language objects that match the specified long description.
     */
    public List<Language> findByLongDescription ( String longDescription ) {
        return languages_Repository.findByLongDescription(longDescription);
    }

    /**
     * Retrieves all languages stored in the database.
     *
     * @return List<Language> - A list of all Language objects.
     */
    public List<Language> findAll () {
        return languages_Repository.findAll();
    }
    
    // any other method for this specific object is useless: addition, deletion and update should be performed directly on the database
    
}