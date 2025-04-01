package everyway.everyway.services.actual_services;

import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.Review;
import everyway.everyway.repositories.Reviews_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class Reviews_Service {

    @Autowired private Reviews_Repository reviews_Repository;

    public Review findById ( int id ) {
        return reviews_Repository.findById(id);
    }

    public List<Review> findByTitle ( String title ) {
        return reviews_Repository.findByTitle(title);
    }

    public List<Review> findByDescription ( String description ) {
        return reviews_Repository.findByDescription(description);
    }

    public List<Review> findByRating ( int rating ) {
        return reviews_Repository.findByRating(rating);
    }

    public List<Review> findByAssociatedAccount ( Account account ) {
        return reviews_Repository.findByAssociatedAccount(account);
    }

    public List<Review> findByAssociatedLocation ( Location location ) {
        return reviews_Repository.findByAssociatedLocation(location);
    }

    public List<Review> findByAssociatedItinerary ( Itinerary itinerary ) {
        return reviews_Repository.findByAssociatedItinerary(itinerary);
    }

    public List<Review> findByIsFactualityReport ( boolean isFactualityReport ) {
        return reviews_Repository.findByIsFactualityReport(isFactualityReport);
    }

    public List<Review> findAll () {
        return reviews_Repository.findAll();
    }
    
}