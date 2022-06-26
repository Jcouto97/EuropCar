package europcar.project.persistence.models.VehicleAtributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import europcar.project.persistence.models.Vehicle;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "colors")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String atribute;

    @JsonIgnore //para problema de recursividade
    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)

    private List<Vehicle> vehicles;

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }
}