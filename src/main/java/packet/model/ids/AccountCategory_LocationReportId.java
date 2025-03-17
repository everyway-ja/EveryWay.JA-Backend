package packet.model.ids;

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

    private int idAssociatedAccountCategory;
    private int idAssociatedLocationReport;

}
