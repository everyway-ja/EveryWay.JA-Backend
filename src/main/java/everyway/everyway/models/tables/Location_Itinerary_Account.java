package everyway.everyway.models.tables;

import java.time.LocalDateTime;
import everyway.everyway.models.ids.Location_Itinerary_AccountId;
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
@IdClass(Location_Itinerary_AccountId.class)
@Table(name = "locations&itineraries_accounts")

public class Location_Itinerary_Account {
    
    @Id @ManyToOne @JoinColumn(name="id_location") private Location associatedLocation;
    @Id @ManyToOne @JoinColumn(name="id_itinerary") private Itinerary associatedItinerary;
    @Id @ManyToOne @JoinColumn(name="id_account") private Account associatedAccount;
    @Id @Column(name="creation_timestamp") private LocalDateTime creationTimestamp;
    
}
