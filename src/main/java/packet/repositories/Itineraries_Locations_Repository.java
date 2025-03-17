package packet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import packet.model.tables.Itinerary;
import packet.model.tables.Location;
import packet.model.tables.Itinerary_Location;
import java.util.List;
import packet.model.ids.Itinerary_LocationId;

@Repository
public interface Itineraries_Locations_Repository extends JpaRepository<Itinerary_Location , Itinerary_LocationId> {

    Itinerary_Location findByAssociatedItineraryAndAssociatedLocation(Itinerary itinerary, Location location);

    List<Itinerary> findByAssociatedItinerary(Itinerary itinerary);
    List<Location> findByAssociatedLocation(Location location);

}