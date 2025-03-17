package packet.model.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import packet.model.ids.AccountCategory_ItineraryId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AccountCategory_ItineraryId.class)
@Table(name = "accountcategories_itineraries")

public class AccountCategory_Itinerary {

    @Id @OneToOne @JoinColumn(name="id_accountcategory") private AccountCategory associatedAccountCategory;
    @Id @OneToOne @JoinColumn(name="id_itinerary") private Itinerary associatedItinerary;

}
