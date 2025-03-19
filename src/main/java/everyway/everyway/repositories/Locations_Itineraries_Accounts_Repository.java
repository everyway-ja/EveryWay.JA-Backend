package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.Location_Itinerary_AccountId;
import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.Location_Itinerary_Account;
import java.util.List;
import java.time.LocalDateTime;
import org.springframework.lang.NonNull;

@Repository
public interface Locations_Itineraries_Accounts_Repository extends JpaRepository<Location_Itinerary_Account, Location_Itinerary_AccountId> {

    Location_Itinerary_Account findByAssociatedLocationAndAssociatedItineraryAndAssociatedAccountAndCreationTimestamp(Location location, Itinerary itinerary, Account account, LocalDateTime creation_timestamp);

    List<Location_Itinerary_Account> findByAssociatedLocation(Location location);
    List<Location_Itinerary_Account> findByAssociatedItinerary(Itinerary itinerary);
    List<Location_Itinerary_Account> findByAssociatedAccount(Account account);

    @NonNull List<Location_Itinerary_Account> findAll();

}