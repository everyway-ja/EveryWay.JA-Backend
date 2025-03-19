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

public class AccountCategory_LocationReportId implements Serializable {

    private int associatedAccountCategory;
    private int associatedLocationReport;

}
