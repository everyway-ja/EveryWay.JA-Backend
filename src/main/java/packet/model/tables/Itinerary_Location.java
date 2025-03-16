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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "itineraries_locations")
@jakarta.persistence.IdClass(Itinerary_LocationId.class)
public class Itinerary_Location {
    
    @Id @ManyToOne @JoinColumn(name="id_itinerary") private Itinerary associatedItinerary;
    @Id @ManyToOne @JoinColumn(name="id_location") private Location associatedLocation;
    @Column(name="index") private int index;

}
