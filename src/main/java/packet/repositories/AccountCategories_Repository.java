package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.AccountCategory;
import java.util.List;


@Repository
public interface AccountCategories_Repository extends JpaRepository<AccountCategory, Integer> {

    AccountCategory findByID(int ID);
    
    List<AccountCategory> findByDescription(String description);

}