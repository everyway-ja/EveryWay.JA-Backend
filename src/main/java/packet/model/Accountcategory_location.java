package packet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

@Table(name = "accountcategories_locations")
public class Accountcategory_location {
    
    @Id @OneToOne @JoinColumn(name="id_accountcategory") private Accountcategory associatedAccountcategory;
    @Id @OneToOne @JoinColumn(name="id_location") private Location associatedLocation;

}
