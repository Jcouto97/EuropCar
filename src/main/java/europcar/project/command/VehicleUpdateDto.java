package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleUpdateDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Size(min = 2, message = "License plate should have at least 2 characters")
    private String licensePlate;

    @Min(1)
    @Max(200)
    private int pricePerDay;

    @Min(1)
    @Max(20)
    private int numOfSeats;
    private LocalDate productionDate;// 2022-06-13

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean rented;

    private String brand;

//    private String type; //car/motorbike/boat, etc
//    private String color;
}
