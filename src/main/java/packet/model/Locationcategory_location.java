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

@Table(name = "locationcategories_locations")
public class Locationcategory_location {
    
    @Id @ManyToOne @JoinColumn(name="id_locationcategory") private Locationcategory associatedLocationcategory;
    @Id @ManyToOne @JoinColumn(name="id_location") private Location associatedLocation;

}
