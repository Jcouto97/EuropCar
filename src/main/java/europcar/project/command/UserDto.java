package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import europcar.project.persistence.models.Rentals;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor //porque??
@Getter
@Setter
@Builder


public class UserDto {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;
    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Column(nullable = false, unique = true)
    private String driversLicense;
    private boolean isRenting;

    @JsonIgnore //para problema de recursividade
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Rentals> rentals = new HashSet<>();

}