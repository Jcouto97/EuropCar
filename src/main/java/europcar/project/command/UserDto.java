package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor //porque??
@Getter
@Setter
@Builder
@ToString

public class UserDto {
    //se nao quiser que id apareça, apago daqui
    //NOTA: Tive problemas no VehicleDto por ter apagado o id (estava a usar os ids da Brand em vez de criar os próprios id)
    //Tive de meter o id novamente no Dto do Vehicle para que isso parasse de acontecer
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;

    //@DateTimeFormat
    private LocalDate dateOfBirth; //n posso por notempty

    @NotEmpty
    @Email
    @Size(min = 4, max = 30, message = "The email must be between 8 and 30 characters")
    private String email;

    @NotEmpty
    @Size(min = 8, max = 30, message = "The password must be between 8 and 30 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotEmpty
    @Size(min = 8, max = 8, message = "Drivers license must have 8 characters")
    private String driversLicense;
    private boolean isRenting;

//    @JsonIgnore //para problema de recursividade
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private Set<Rental> rentals = new HashSet<>();

    //O User não precisa de UserDtoWithId porque, em princípio, não tem tabelas à parte
}
