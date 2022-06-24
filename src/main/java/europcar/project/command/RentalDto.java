package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import europcar.project.persistence.models.Vehicle;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.apache.tomcat.jni.User;

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
    private User user;
    private Vehicle vehicle;
    private LocalDate rentDate = LocalDate.now();
    private LocalDate returnDate = LocalDate.now();
    private int missingFuelPrice = 2;
}
