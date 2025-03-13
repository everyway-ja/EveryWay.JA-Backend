package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ItineraryCategory;
import java.util.List;


@Repository
public interface ItineraryCategories_Repsitory extends JpaRepository<ItineraryCategory, Integer> {

    ItineraryCategory findByID(int ID);
    
    List<ItineraryCategory> findByDescription(String description);

}