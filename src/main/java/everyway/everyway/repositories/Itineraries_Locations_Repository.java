package everyway.everyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import everyway.everyway.models.ids.Itinerary_LocationId;
import everyway.everyway.models.tables.Itinerary;
import everyway.everyway.models.tables.Itinerary_Location;
import everyway.everyway.models.tables.Location;
import java.util.List;
import org.springframework.lang.NonNull;

@Repository

public interface Itineraries_Locations_Repository extends JpaRepository<Itinerary_Location , Itinerary_LocationId> {

    Itinerary_Location findByAssociatedItineraryAndAssociatedLocation(Itinerary itinerary, Location location);

    List<Itinerary> findByAssociatedItinerary(Itinerary itinerary);
    List<Location> findByAssociatedLocation(Location location);

    @NonNull List<Itinerary_Location> findAll();

}