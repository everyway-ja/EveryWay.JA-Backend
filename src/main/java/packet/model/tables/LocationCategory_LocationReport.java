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

@Table(name = "locationcategories_locationreports")
public class LocationCategory_LocationReport {
    
    @Id @ManyToOne @JoinColumn(name="id_locationcategory") private LocationCategory associatedLocationCategory;
    @Id @ManyToOne @JoinColumn(name="id_locationreport") private LocationReport associatedLocationReport;

}
