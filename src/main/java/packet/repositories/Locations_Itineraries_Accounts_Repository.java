package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.AccountCategory_LocationId;
import packet.model.ids.Location_Itinerary_AccountId;
import packet.model.tables.*;
        import java.util.List;

@Repository
public interface Locations_Itineraries_Accounts_Repository extends JpaRepository<Location_Itinerary_Account, Location_Itinerary_AccountId> {

    Location_Itinerary_Account findByAssociatedLocationAndAssociatedItineraryAndAssociatedAccount(Location location, Itinerary itinerary, Account account);

    List<Location_Itinerary_Account> findByAssociatedLocation(Location location);
    List<Location_Itinerary_Account> findByAssociatedItinerary(Itinerary itinerary);
    List<Location_Itinerary_Account> findByAssociatedAccount(Account account);
}