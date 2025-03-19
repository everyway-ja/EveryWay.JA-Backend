package everyway.everyway.models.ids;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class ItineraryCategory_ItineraryId implements Serializable {

    private int associatedItineraryCategory;
    private int associatedItinerary;

}
