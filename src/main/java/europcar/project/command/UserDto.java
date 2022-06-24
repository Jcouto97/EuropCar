package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import europcar.project.persistence.models.Rental;
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
@ToString


public class UserDto {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;
    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Size(min = 8, max = 30, message = "The password must be between 8 and 30 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false, unique = true)
    private String driversLicense;
    private boolean isRenting;

    @JsonIgnore //para problema de recursividade
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Rental> rentals = new HashSet<>();

}