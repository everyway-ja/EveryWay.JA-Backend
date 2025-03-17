package packet.model.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import packet.model.ids.LocationCategory_LocationReportId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(LocationCategory_LocationReportId.class)
@Table(name = "locationcategories_locationreports")

public class LocationCategory_LocationReport {
    
    @Id @ManyToOne @JoinColumn(name="id_locationcategory") private LocationCategory associatedLocationCategory;
    @Id @ManyToOne @JoinColumn(name="id_locationreport") private LocationReport associatedLocationReport;

}
