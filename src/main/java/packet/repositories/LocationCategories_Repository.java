package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.tables.LocationCategory;
import java.util.List;


@Repository
public interface LocationCategories_Repository extends JpaRepository<LocationCategory, Integer> {

    LocationCategory findById(int id);
    
    List<LocationCategory> findByDescription(String description);

}