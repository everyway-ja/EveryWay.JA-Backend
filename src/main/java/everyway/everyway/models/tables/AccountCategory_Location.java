package everyway.everyway.models.tables;

import everyway.everyway.models.ids.AccountCategory_LocationId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AccountCategory_LocationId.class)
@Table(name = "accountcategories_locations")

public class AccountCategory_Location {
    
    @Id @ManyToOne @JoinColumn(name="id_accountcategory") private AccountCategory associatedAccountCategory;
    @Id @ManyToOne @JoinColumn(name="id_location") private Location associatedLocation;

}
