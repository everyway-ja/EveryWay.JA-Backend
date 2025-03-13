package packet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "itinerarycategories")
public class ItineraryCategory {
    
    @Id @Column(name="ID") @GeneratedValue(strategy = GenerationType.IDENTITY) private int ID;
    @Column(name="description") private String description;

}
