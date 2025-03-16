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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "accountcategories_locationreports")
@IdClass(AccountCategory_LocationReportId.class)
public class AccountCategory_LocationReport {
    
    @Id @ManyToOne @JoinColumn(name="id_accountcategory") private AccountCategory associatedAccountCategory;
    @Id @ManyToOne @JoinColumn(name="id_locationreport") private LocationReport associatedLocationReport;

}
