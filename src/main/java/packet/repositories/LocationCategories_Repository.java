package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.tables.LocationCategory;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface LocationCategories_Repository extends JpaRepository<LocationCategory, Integer> {

    LocationCategory findById(int id);
    
    List<LocationCategory> findByDescription(String description);

    @NonNull List<LocationCategory> findAll();

}