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
public class RentalDto2 {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private Long userId;
    private Long vehicleId;
    private LocalDate rentDate = LocalDate.now();
    private LocalDate returnDate = LocalDate.now();
    private int missingFuelPrice = 2;
}