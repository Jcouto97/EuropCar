package europcar.project.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor //porque??
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Table(name = "users")
public class User {
    //commit
    //sdsf
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    private String name;
    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false, unique = true)
    private String driversLicense;
    private boolean isRenting;

    @JsonIgnore //para problema de recursividade
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Rental> rentals;

    //metodo no controller para vir buscar aqui ao user
    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }
}
