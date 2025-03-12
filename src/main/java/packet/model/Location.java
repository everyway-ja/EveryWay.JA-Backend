package packet.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Table(name = "locations")
public class Location {
    
    @Id @Column(name="ID") @GeneratedValue(strategy = GenerationType.IDENTITY) private int ID;
    @Column(name="name") private String name;
    @Column(name="description") private String description;
    @OneToOne @JoinColumn(name = "id_position") private Position associatedPosition;
    @ManyToOne @JoinColumn(name = "id_account") private Account asssociatedAccount;
    @CreationTimestamp @Column(name="creation_timestamp") private LocalDateTime creation_timestamp;
    @UpdateTimestamp @Column(name="update_timestamp") private LocalDateTime update_timestamp;
    @Column(name="deletion_timestamp") private LocalDateTime deletion_timestamp;
    
}
