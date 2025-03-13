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
public class AccountCategory_Location {
    
    @Id @OneToOne @JoinColumn(name="id_accountcategory") private AccountCategory associatedAccountCategory;
    @Id @OneToOne @JoinColumn(name="id_location") private Location associatedLocation;

}
