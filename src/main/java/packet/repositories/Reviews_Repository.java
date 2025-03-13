package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.Review;
import java.util.List;
import packet.model.Account;
import packet.model.Location;
import packet.model.Itinerary;

@Repository
public interface Reviews_Repository extends JpaRepository<Review, Integer> {

    Review findByID(int ID);
    
    List<Review> findByTitle(String title);
    List<Review> findByDescription(String description);
    List<Review> findByRating(int rating);
    List<Review> findByAssociatedAccount(Account associatedAccount);
    List<Review> findByAssociatedLocation(Location associatedLocation);
    List<Review> findByAssociatedItinerary(Itinerary associatedItinerary);
    List<Review> findByIsFactualityReport(boolean isFactualityReport);

}