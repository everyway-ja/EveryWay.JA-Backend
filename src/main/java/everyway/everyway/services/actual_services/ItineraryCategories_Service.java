package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.ItineraryCategory;
import everyway.everyway.repositories.ItineraryCategories_Repsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ItineraryCategories_Service {

    @Autowired private ItineraryCategories_Repsitory itineraryCategories_Repsitory;

    public ItineraryCategory findById ( int id ) {
        return itineraryCategories_Repsitory.findById(id);
    }

    public List<ItineraryCategory> findByDescription ( String description ) {
        return itineraryCategories_Repsitory.findByDescription(description);
    }

    public List<ItineraryCategory> findAll () {
        return itineraryCategories_Repsitory.findAll();
    }
    
}