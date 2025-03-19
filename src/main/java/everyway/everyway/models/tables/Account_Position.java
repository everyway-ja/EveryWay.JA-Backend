package everyway.everyway.models.tables;

import java.time.LocalDateTime;
import everyway.everyway.models.ids.Account_PositionId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Id @Column(name="creation_timestamp") private LocalDateTime creationTimestamp;

}
