package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.tables.Account;
import packet.model.tables.Itinerary;
import packet.model.tables.Location;
import packet.model.tables.Review;
import java.util.List;

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

}