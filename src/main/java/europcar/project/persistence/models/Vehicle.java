package europcar.project.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import europcar.project.persistence.models.VehicleAtributes.Brand;
import lombok.*;

import javax.persistence.*;
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

    @Column(nullable = false, unique = true, updatable = false)
    private String licensePlate;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Rental> rentals;
    private int pricePerDay;
    private int numOfSeats;
    private LocalDate productionDate;// 2022-06-13
    private boolean rented;

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    //    private String type; //car/motorbike/boat, etc

    @ManyToOne(cascade = CascadeType.DETACH)
    //DETACH em vez de ALL, porque com ALL, ao apagar um vehículo, todos os vehículos com a mesma marca eram apagados
    @JoinColumn(name = "brandId", referencedColumnName = "id")
    private Brand brand;
//    private String color;
//    Classes que só têm um Long id e uma String
//    A List fica do lado dos vehículos
}
