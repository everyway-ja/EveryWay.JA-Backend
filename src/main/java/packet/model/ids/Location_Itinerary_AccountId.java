package packet.model.ids;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Location_Itinerary_AccountId implements Serializable {

    private int associatedLocation;
    private int associatedItinerary;
    private int associatedAccount;
    private LocalDateTime creationTimestamp;

}
