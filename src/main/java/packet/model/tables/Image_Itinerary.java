package packet.model.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import packet.model.ids.Image_ItineraryId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(Image_ItineraryId.class)
@Table(name = "images_itineraries")

public class Image_Itinerary {

    @Id @ManyToOne @JoinColumn(name="id_image") private Image associatedImage;
    @Id @ManyToOne @JoinColumn(name="id_itinerary") private Itinerary associatedItinerary;

}
