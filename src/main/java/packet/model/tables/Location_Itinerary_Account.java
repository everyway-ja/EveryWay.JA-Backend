package packet.model.tables;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import packet.model.ids.Location_Itinerary_AccountId;

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
    @CreationTimestamp @Column(name="creation_timestamp") private LocalDateTime creation_timestamp;
    
}
