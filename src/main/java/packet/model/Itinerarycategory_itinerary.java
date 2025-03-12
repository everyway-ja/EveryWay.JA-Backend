package packet.model;

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
public class Itinerarycategory_itinerary {
    
    @Id @ManyToOne @JoinColumn(name="id_itinerarycategory") private Itinerarycategory associatedItinerarycategory;
    @Id @ManyToOne @JoinColumn(name="id_itinerary") private Itinerary associatedItinerary;

}
