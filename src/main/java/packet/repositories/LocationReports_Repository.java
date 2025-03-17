package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.tables.Account;
import packet.model.tables.LocationReport;
import packet.model.tables.Position;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface LocationReports_Repository extends JpaRepository<LocationReport, Integer> {

    LocationReport findById(int id);
    
    List<LocationReport> findByName(String name);
    List<LocationReport> findByDescription(String description);
    List<LocationReport> findByAssociatedAccount(Account associatedAccount);
    List<LocationReport> findByAssociatedPosition(Position associatedPosition);

    @NonNull List<LocationReport> findAll();

}