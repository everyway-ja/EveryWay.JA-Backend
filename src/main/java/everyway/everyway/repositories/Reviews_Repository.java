package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.Review;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface Reviews_Repository extends JpaRepository<Review, Integer> {

    Review findById(int id);
    
    List<Review> findByTitle(String title);
    List<Review> findByDescription(String description);
    List<Review> findByRating(int rating);
    List<Review> findByAssociatedAccount(Account associatedAccount);
    List<Review> findByAssociatedLocation(Location associatedLocation);
    List<Review> findByAssociatedItinerary(Itinerary associatedItinerary);
    List<Review> findByIsFactualityReport(boolean isFactualityReport);

    @NonNull List<Review> findAll();

}