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
     * Fetches a review by its unique identifier.
     *
     * @param id The unique identifier of the review.
     * @return Review - The Review object matching the given ID, or null if no match is found.
     */
    public Review findById ( int id ) {
        return reviews_Repository.findById(id);
    }

    /**
     * Retrieves all reviews with a specific title.
     *
     * @param title The title to filter reviews by.
     * @return List<Review> - A list of Review objects that match the specified title.
     */
    public List<Review> findByTitle ( String title ) {
        return reviews_Repository.findByTitle(title);
    }

    /**
     * Retrieves all reviews containing a specific description.
     *
     * @param description The description to filter reviews by.
     * @return List<Review> - A list of Review objects that match the specified description.
     */
    public List<Review> findByDescription ( String description ) {
        return reviews_Repository.findByDescription(description);
    }

    /**
     * Retrieves all reviews with a specific rating.
     *
     * @param rating The rating to filter reviews by.
     * @return List<Review> - A list of Review objects that match the specified rating.
     */
    public List<Review> findByRating ( int rating ) {
        return reviews_Repository.findByRating(rating);
    }

    /**
     * Retrieves all reviews associated with a specific account.
     *
     * @param account The Account object to filter reviews by.
     * @return List<Review> - A list of Review objects linked to the specified account.
     */
    public List<Review> findByAssociatedAccount ( Account account ) {
        return reviews_Repository.findByAssociatedAccount(account);
    }

    /**
     * Retrieves all reviews associated with a specific location.
     *
     * @param location The Location object to filter reviews by.
     * @return List<Review> - A list of Review objects linked to the specified location.
     */
    public List<Review> findByAssociatedLocation ( Location location ) {
        return reviews_Repository.findByAssociatedLocation(location);
    }

    /**
     * Retrieves all reviews associated with a specific itinerary.
     *
     * @param itinerary The Itinerary object to filter reviews by.
     * @return List<Review> - A list of Review objects linked to the specified itinerary.
     */
    public List<Review> findByAssociatedItinerary ( Itinerary itinerary ) {
        return reviews_Repository.findByAssociatedItinerary(itinerary);
    }

    /**
     * Retrieves all reviews based on their factuality report status.
     *
     * @param isFactualityReport A boolean indicating whether to filter by factuality reports.
     * @return List<Review> - A list of Review objects matching the specified factuality report status.
     */
    public List<Review> findByIsFactualityReport ( boolean isFactualityReport ) {
        return reviews_Repository.findByIsFactualityReport(isFactualityReport);
    }

    /**
     * Retrieves all reviews stored in the database.
     *
     * @return List<Review> - A list of all Review objects.
     */
    public List<Review> findAll () {
        return reviews_Repository.findAll();
    }
    
}