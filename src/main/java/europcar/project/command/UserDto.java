package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import europcar.project.persistence.models.Rental;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;

    @DateTimeFormat
    private LocalDate dateOfBirth; //n posso por notempty

    @NotEmpty
    @Email
    @Size(min = 4, max = 30, message = "The email must be between 8 and 30 characters")
    private String email;

    @NotEmpty
    @Size(min = 8, max = 30, message = "The password must be between 8 and 30 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Size(min = 8, max = 8, message = "Drivers license must have 8 characters")
    private String driversLicense;
    private boolean isRenting;

    @JsonIgnore //para problema de recursividade
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Rental> rentals = new HashSet<>();

}