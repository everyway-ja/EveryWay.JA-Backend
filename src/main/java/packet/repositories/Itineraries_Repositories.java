package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.Itinerary;
import packet.model.Account;
import java.util.List;


@Repository
public interface Itineraries_Repositories extends JpaRepository<Itinerary, Integer> {

    Itinerary findByID(int ID);
    
    List<Itinerary> findByName(String name);
    List<Itinerary> findByDescription(String description);
    List<Itinerary> findByAssociatedAccount(Account account);

}