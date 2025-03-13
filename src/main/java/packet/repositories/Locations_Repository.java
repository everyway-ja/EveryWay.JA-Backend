package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.Location;
import packet.model.Account;
import packet.model.Position;
import java.util.List;


@Repository
public interface Locations_Repository extends JpaRepository<Location, Integer> {

    Location findByID(int ID);
    
    List<Location> findByName(String name);
    List<Location> findByDescription(String description);
    List<Location> findByAssociatedPosition(Position position);
    List<Location> findByAssociatedAccount(Account account);

}