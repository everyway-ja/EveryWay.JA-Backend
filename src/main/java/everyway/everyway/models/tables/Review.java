package everyway.everyway.models.tables;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")

public class Review {
    
    @Id @Column(name="ID") @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @Column(name="title") private String title;
    @Column(name="description") private String description;
    @Column(name="rating") private int rating;
    @ManyToOne @JoinColumn(name="id_account") private Account associatedAccount;
    @ManyToOne @JoinColumn(name="id_location") private Location associatedLocation;
    @ManyToOne @JoinColumn(name="id_itinerary") private Itinerary associatedItinerary;
    @CreationTimestamp @Column(name="creation_timestamp") private LocalDateTime creation_timestamp;
    @UpdateTimestamp @Column(name="update_timestamp") private LocalDateTime update_timestamp;
    @Column(name="deletion_timestamp") private LocalDateTime deletion_timestamp;
    @Column(name="isFactualityReport") private boolean isFactualityReport;

}
