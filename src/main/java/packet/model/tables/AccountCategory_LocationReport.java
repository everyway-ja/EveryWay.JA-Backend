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

@Table(name = "accountcategories_locationreports")
public class AccountCategory_LocationReport {
    
    @Id @ManyToOne @JoinColumn(name="id_accountcategory") private AccountCategory associatedAccountCategory;
    @Id @ManyToOne @JoinColumn(name="id_locationreport") private LocationReport associatedLocationReport;

}
