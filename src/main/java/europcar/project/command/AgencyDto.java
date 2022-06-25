package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class AgencyDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //write only para n aparecer id?
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Agency name should have at least 2 characters")
    private String name;

    @NotEmpty
    @Size(min = 2, message = "Agency location should have at least 3 characters")
    private String location;

}

