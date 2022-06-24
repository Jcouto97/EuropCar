package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "userId", referencedColumnName = "id")
    //private User user;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "vehicleId", referencedColumnName = "id")
    //private Vehicle vehicle;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int missingFuelPrice;
}
