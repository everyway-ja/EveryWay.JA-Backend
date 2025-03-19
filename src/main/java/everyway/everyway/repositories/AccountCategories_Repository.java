package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.tables.AccountCategory;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface AccountCategories_Repository extends JpaRepository<AccountCategory, Integer> {

    AccountCategory findById(int id);
    
    List<AccountCategory> findByDescription(String description);

    @NonNull List<AccountCategory> findAll();

}