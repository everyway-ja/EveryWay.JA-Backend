package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.Position;
import java.util.List;

@Repository
public interface Positions_Repository extends JpaRepository<Position, Integer> {

    Position findByID(int ID);
    
    List<Position> findByX_coordinate(double x_coordinate);
    List<Position> findByY_coordinate(double y_coordinate);
    List<Position> findByNation(String nation);
    List<Position> findByRegion_state(String region_state);
    List<Position> findByProvince(String province);
    List<Position> findByCity_town(String city_town);
    List<Position> findByAddress(String address);
    List<Position> findByPostalcode(String postalcode);

}