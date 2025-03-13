package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.LocationReport;
import packet.model.Account;
import packet.model.Position;
import java.util.List;


@Repository
public interface LocationReport_Repository extends JpaRepository<LocationReport, Integer> {

    LocationReport findByID(int ID);
    List<LocationReport> findByName(String name);
    List<LocationReport> findByDescription(String description);
    List<LocationReport> findByAssociatedAccount(Account associatedAccount);
    List<LocationReport> findByAssociatedPosition(Position associatedPosition);

}