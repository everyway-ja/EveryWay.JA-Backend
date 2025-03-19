package everyway.everyway.models.tables;

import everyway.everyway.models.ids.ItineraryCategory_ItineraryId;
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
