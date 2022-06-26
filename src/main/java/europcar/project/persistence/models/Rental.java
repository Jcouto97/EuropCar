package europcar.project.persistence.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "userId", referencedColumnName = "id") //userIdFk == ao id do user
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "vehicleId", referencedColumnName = "id")
    private Vehicle vehicle;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "agencyId", referencedColumnName = "id")
    private Agency agency;

    private LocalDate rentDate;
    private LocalDate returnDate;
    private int price;
    private boolean paid;
}
