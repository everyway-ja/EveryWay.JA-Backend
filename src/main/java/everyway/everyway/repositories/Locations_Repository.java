package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.Position;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface Locations_Repository extends JpaRepository<Location, Integer> {

    Location findById(int id);
    
    List<Location> findByName(String name);
    List<Location> findByDescription(String description);
    List<Location> findByAssociatedPosition(Position position);
    List<Location> findByAssociatedAccount(Account account);

    @NonNull List<Location> findAll();

}