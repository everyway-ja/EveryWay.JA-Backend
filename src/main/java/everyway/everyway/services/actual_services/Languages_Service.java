package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Language;
import everyway.everyway.repositories.Languages_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Languages_Service {

    @Autowired private Languages_Repository languages_Repository;

    public Language findById ( int id ) {
        return languages_Repository.findById(id);
    }

    public List<Language> findByShortDescription ( String shortDescription ) {
        return languages_Repository.findByShortDescription(shortDescription);
    }

    public List<Language> findByLongDescription ( String longDescription ) {
        return languages_Repository.findByLongDescription(longDescription);
    }

    public List<Language> findAll () {
        return languages_Repository.findAll();
    }
}