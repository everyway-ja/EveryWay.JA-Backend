package packet.model.tables;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Table(name = "accounts_positions")
public class Account_Position {
    
    @Id @ManyToOne @JoinColumn(name="id_account") private Account associatedAccount;
    @Id @ManyToOne @JoinColumn(name="id_position") private Position associatedPosition;
    @Column(name="isAccountHome") private boolean isAccountHome;
    @CreationTimestamp @Column(name="creation_timestamp") private LocalDateTime creation_timestamp;

}
