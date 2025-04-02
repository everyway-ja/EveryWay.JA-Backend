package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.tables.Image;
import java.util.List;

@Repository

public interface Images_Repository extends JpaRepository<Image, Integer> {

    Image findById(int id);

    List<Image> findByImagePath(String imagePath);

}