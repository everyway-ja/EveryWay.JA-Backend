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
import jakarta.persistence.IdClass;
import packet.model.ids.ItineraryCategory_ItineraryId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ItineraryCategory_ItineraryId.class)
@Table(name = "itinerarycategories_itineraries")

public class ItineraryCategory_Itinerary {
    
    @Id @ManyToOne @JoinColumn(name="id_itinerarycategory") private ItineraryCategory associatedItineraryCategory;
    @Id @ManyToOne @JoinColumn(name="id_itinerary") private Itinerary associatedItinerary;

}
