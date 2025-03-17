package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.tables.AccountCategory;
import java.util.List;

@Repository
public interface AccountCategories_Repository extends JpaRepository<AccountCategory, Integer> {

    AccountCategory findById(int id);
    
    List<AccountCategory> findByDescription(String description);

}