package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.tables.Account;
import packet.model.tables.Itinerary;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface Itineraries_Repositories extends JpaRepository<Itinerary, Integer> {

    Itinerary findById(int id);
    
    List<Itinerary> findByName(String name);
    List<Itinerary> findByDescription(String description);
    List<Itinerary> findByAssociatedAccount(Account account);

    @NonNull List<Itinerary> findAll();

}