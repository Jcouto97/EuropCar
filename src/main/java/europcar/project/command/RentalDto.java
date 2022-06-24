package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RentalDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "userId", referencedColumnName = "id")
    //private User user;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "vehicleId", referencedColumnName = "id")
    //private Vehicle vehicle;
    @NotNull
    private LocalDate rentDate;
    private LocalDate returnDate = LocalDate.now();

    @Min(0)
    @Max(5)
    private int missingFuelPrice = 2;
}
