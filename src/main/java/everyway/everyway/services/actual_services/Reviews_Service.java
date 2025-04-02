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

    /**
     * Retrieves a review by its ID.
     * 
     * This method queries the repository to find a review with the specified ID.
     * 
     * @param id the ID of the review to search for
     * @return the review with the specified ID, or null if not found
     */
    public Review findById ( int id ) {
        return reviews_Repository.findById(id);
    }

    /**
     * Retrieves a list of reviews by title.
     * 
     * This method queries the repository to find reviews that match the specified title.
     * 
     * @param title the title of the reviews to search for
     * @return a list of reviews that match the specified title
     */
    public List<Review> findByTitle ( String title ) {
        return reviews_Repository.findByTitle(title);
    }

    /**
     * Retrieves a list of reviews by description.
     * 
     * This method queries the repository to find reviews that match the specified description.
     * 
     * @param description the description of the reviews to search for
     * @return a list of reviews that match the specified description
     */
    public List<Review> findByDescription ( String description ) {
        return reviews_Repository.findByDescription(description);
    }

    /**
     * Retrieves a list of reviews by rating.
     * 
     * This method queries the repository to find reviews that match the specified rating.
     * 
     * @param rating the rating of the reviews to search for
     * @return a list of reviews that match the specified rating
     */
    public List<Review> findByRating ( int rating ) {
        return reviews_Repository.findByRating(rating);
    }

    /**
     * Retrieves a list of reviews by associated account.
     * 
     * This method queries the repository to find reviews associated with the specified account.
     * 
     * @param account the account whose reviews to search for
     * @return a list of reviews associated with the specified account
     */
    public List<Review> findByAssociatedAccount ( Account account ) {
        return reviews_Repository.findByAssociatedAccount(account);
    }

    /**
     * Retrieves a list of reviews by associated location.
     * 
     * This method queries the repository to find reviews associated with the specified location.
     * 
     * @param location the location whose reviews to search for
     * @return a list of reviews associated with the specified location
     */
    public List<Review> findByAssociatedLocation ( Location location ) {
        return reviews_Repository.findByAssociatedLocation(location);
    }

    /**
     * Retrieves a list of reviews by associated itinerary.
     * 
     * This method queries the repository to find reviews associated with the specified itinerary.
     * 
     * @param itinerary the itinerary whose reviews to search for
     * @return a list of reviews associated with the specified itinerary
     */
    public List<Review> findByAssociatedItinerary ( Itinerary itinerary ) {
        return reviews_Repository.findByAssociatedItinerary(itinerary);
    }

    /**
     * Retrieves a list of reviews by factuality report status.
     * 
     * This method queries the repository to find reviews that are either factuality reports or not,
     * depending on the specified `isFactualityReport` flag.
     * 
     * @param isFactualityReport flag to indicate if the review is a factuality report
     * @return a list of reviews that match the specified factuality report status
     */
    public List<Review> findByIsFactualityReport ( boolean isFactualityReport ) {
        return reviews_Repository.findByIsFactualityReport(isFactualityReport);
    }

    /**
     * Retrieves a list of all reviews.
     * 
     * This method queries the repository to return all available reviews in the database.
     * 
     * @return a list of all reviews
     */
    public List<Review> findAll () {
        return reviews_Repository.findAll();
    }
    
}