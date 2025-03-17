package packet.model.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.IdClass;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(packet.model.ids.AccountCategory_AccountId.class)
@Table(name = "accountcategories_accounts")
public class AccountCategory_Account {

    @Id @OneToOne @JoinColumn(name="id_accountcategories") private AccountCategory associatedAccountCategory;
    @Id @OneToOne @JoinColumn(name="id_account") private Account associatedAccount;

}
