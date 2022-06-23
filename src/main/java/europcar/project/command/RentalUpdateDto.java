package europcar.project.command;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class RentalUpdateDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "userId", referencedColumnName = "id")
    //private User user;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "vehicleId", referencedColumnName = "id")
    //private Vehicle vehicle;

    private LocalDate rentDate;
    private LocalDate returnDate;
    private int missingFuelPrice;
}
