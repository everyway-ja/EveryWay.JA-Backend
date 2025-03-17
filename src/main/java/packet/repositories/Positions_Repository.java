package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.tables.Position;
import java.util.List;

@Repository
public interface Positions_Repository extends JpaRepository<Position, Integer> {

    Position findById(int id);
    
    List<Position> findByNation(String nation);
    List<Position> findByRegionState(String region_state);
    List<Position> findByProvince(String province);
    List<Position> findByCityTown(String city_town);
    List<Position> findByAddress(String address);
    List<Position> findByPostalcode(String postalcode);

}