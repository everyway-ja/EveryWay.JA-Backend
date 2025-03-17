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
import packet.model.ids.LocationCategory_LocationId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(LocationCategory_LocationId.class)
@Table(name = "locationcategories_locations")

public class LocationCategory_Location {
    
    @Id @ManyToOne @JoinColumn(name="id_locationcategory") private LocationCategory associatedLocationCategory;
    @Id @ManyToOne @JoinColumn(name="id_location") private Location associatedLocation;

}
