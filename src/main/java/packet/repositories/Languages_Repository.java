package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import packet.model.tables.Language;

import java.util.List;


@Repository
public interface Languages_Repository extends JpaRepository<Language, Integer> {

    Language findById(int ID);
    
    List<Language> findByShortDescription(String shortDescription);
    List<Language> findByLongDescription(String longDescription);

}