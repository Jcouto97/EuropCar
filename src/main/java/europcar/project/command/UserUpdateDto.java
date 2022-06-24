package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserUpdateDto { //tudo o que posso alterar
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Size(min = 2, max = 30, message = "The name must be between 2 and 30 characters")
    private String name;

    @Size(min = 2, max = 40, message = "The email must be between 2 and 40 characters")
    @Email
    private String email;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate dateOfBirth;

    @Size(min = 8, max = 30, message = "The password must be between 8 and 30 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
