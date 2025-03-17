package packet.model.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.IdClass;
import packet.model.ids.Itinerary_LocationId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(
Itinerary_LocationId.class)
@Table(name = "itineraries_locations")
public class Itinerary_Location {
    
    @Id @ManyToOne @JoinColumn(name="id_itinerary") private Itinerary associatedItinerary;
    @Id @ManyToOne @JoinColumn(name="id_location") private Location associatedLocation;
    @Column(name="index") private int index;

}
