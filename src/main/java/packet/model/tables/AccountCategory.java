package packet.model.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accountcategories")
public class AccountCategory {
    
    @Id @Column(name="ID") @GeneratedValue(strategy = GenerationType.IDENTITY) private int id; 
    @Column(name="description") private String description;

}
