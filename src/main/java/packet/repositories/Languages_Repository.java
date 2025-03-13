package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.Language;
import java.util.List;


@Repository
public interface Languages_Repository extends JpaRepository<Language, Integer> {

    Language findByID(int ID);
    
    List<Language> findByShortDescription(String short_description);
    List<Language> findByLongDescription(String long_description);

}