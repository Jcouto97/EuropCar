package europcar.project.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true, updatable = false)
    @Size(min = 2, message = "License plate should have at least 2 characters")
    private String licensePlate;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Rental> rentals;

//    private String type; //car/motorbike/boat, etc

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "branchIdFk", referencedColumnName = "id")
//    private Brand brand;
//
//    private String color;
    private Long numOfSeats;
    private Long pricePerHour;
    private LocalDate productionDate;// 2022-06-13
    private LocalDate registrationDate;// 2022-06-13
    private boolean isRented;

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }
}
