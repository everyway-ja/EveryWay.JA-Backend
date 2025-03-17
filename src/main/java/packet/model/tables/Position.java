package packet.model.tables;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "positions")

public class Position {
    
    @Id @Column(name="ID") @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Column(name="x_coordinate") private float xCoordinate;
    @Column(name="y_coordinate") private float yCoordinate;
    @Column(name="nation") private String nation;
    @Column(name="region_state") private String regionState;
    @Column(name="province") private String province;
    @Column(name="city_town") private String cityTown;
    @Column(name="address") private String address;
    @Column(name="postalcode") private String postalcode;
    @CreationTimestamp @Column(name="creation_timestamp") private LocalDateTime creation_timestamp;

}
