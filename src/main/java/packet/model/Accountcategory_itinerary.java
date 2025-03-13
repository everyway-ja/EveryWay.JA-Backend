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

@Table(name = "accountcategories_itineraries")
public class AccountCategory_Itinerary {

    @Id @OneToOne @JoinColumn(name="id_accountcategory") private AccountCategory associatedAccountCategory;
    @Id @OneToOne @JoinColumn(name="id_itinerary") private Itinerary associatedItinerary;

}
