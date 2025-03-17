package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.ids.Location_Itinerary_AccountId;
import packet.model.tables.Location_Itinerary_Account;
import java.util.List;
import packet.model.tables.Account;
import packet.model.tables.Itinerary;
import packet.model.tables.Location;
import java.time.LocalDateTime;

@Repository
public interface Locations_Itineraries_Accounts_Repository extends JpaRepository<Location_Itinerary_Account, Location_Itinerary_AccountId> {

    Location_Itinerary_Account findByAssociatedLocationAndAssociatedItineraryAndAssociatedAccountAndCreationTimestamp(Location location, Itinerary itinerary, Account account, LocalDateTime creation_timestamp);

    List<Location_Itinerary_Account> findByAssociatedLocation(Location location);
    List<Location_Itinerary_Account> findByAssociatedItinerary(Itinerary itinerary);
    List<Location_Itinerary_Account> findByAssociatedAccount(Account account);

}