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
public class RentalDto {
    //filtrar para retornar id em vez de objetos
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private Long userId;
    private Long vehicleId;
    private Long agencyId;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int price;
    private boolean paid;
}
