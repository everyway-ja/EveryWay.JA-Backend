package everyway.everyway.models.tables;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locationreports")

public class LocationReport {
    
    @Id @Column(name="ID") @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Column(name="name") private String name;
    @Column(name="description") private String description;
    @ManyToOne @JoinColumn(name = "id_account") private Account associatedAccount;
    @ManyToOne @JoinColumn(name = "id_position") private Position associatedPosition;
    @CreationTimestamp @Column(name="creation_timestamp") private LocalDateTime creation_timestamp;
    
}
