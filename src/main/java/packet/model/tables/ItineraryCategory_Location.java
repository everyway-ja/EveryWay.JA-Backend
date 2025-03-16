package packet.model.tables;

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

@Table(name = "itinerarycategories_itineraries")
@jakarta.persistence.IdClass(ItineraryCategory_LocationId.class)
public class ItineraryCategory_Location {
    
    @Id @ManyToOne @JoinColumn(name="id_itinerarycategory") private ItineraryCategory associatedItineraryCategory;
    @Id @ManyToOne @JoinColumn(name="id_itinerary") private Itinerary associatedItinerary;

}
