package packet.model.tables;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import packet.model.ids.Account_PositionId;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(Account_PositionId.class)
@Table(name = "accounts_positions")
public class Account_Position {
    
    @Id @ManyToOne @JoinColumn(name="id_account") private Account associatedAccount;
    @Id @ManyToOne @JoinColumn(name="id_position") private Position associatedPosition;
    @Column(name="isAccountHome") private boolean isAccountHome;
    @Id @CreationTimestamp @Column(name="creation_timestamp") private LocalDateTime creation_timestamp;

}
