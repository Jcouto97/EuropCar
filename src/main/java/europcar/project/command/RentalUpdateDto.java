package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import europcar.project.persistence.models.User;
import europcar.project.persistence.models.Vehicle;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RentalUpdateDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private User user;
    private Vehicle vehicle;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int missingFuelPrice;
}
