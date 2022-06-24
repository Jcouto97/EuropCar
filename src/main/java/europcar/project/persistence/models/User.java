package europcar.project.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Entity
@NoArgsConstructor //porque??
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Table(name = "Users")

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

    private String password;

    @Column(nullable = false, unique = true)
    private String driversLicense;
    private boolean isRenting;

//    @JsonIgnore //para problema de recursividade
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<Rental> rentals = new HashSet<>();

    //metodo no controller para vir buscar aqui ao user

}

