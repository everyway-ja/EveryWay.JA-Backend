package packet.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="accounts")
public class Account {

    @Id @Column(name="ID") @GeneratedValue(strategy = GenerationType.IDENTITY) private int ID;
    @Column(name="name") private String name;
    @Column(name="surname") private String surname;
    @Column(name="username") private String username;
    @Column(name="email") private String email;
    @Column(name="password") private String password;
    @Column(name="birthdate") private LocalDate birthDate;
    @OneToOne @JoinColumn(name="language") private Language associatedLanguage;
    @CreationTimestamp @Column(name="creation_timestamp") private LocalDateTime creation_timestamp;
    @UpdateTimestamp @Column(name="update_timestamp") private LocalDateTime update_timestamp;
    @Column(name="deletion_timestamp") private LocalDateTime deletion_timestamp;

}