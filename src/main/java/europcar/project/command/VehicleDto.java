package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Month;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class VehicleDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "License plate should have at least 2 characters")
    private String licensePlate;

    @Min(1)
    @Max(200)
    private int pricePerDay;

    @Min(1)
    @Max(20)
    private int numOfSeats;
    private LocalDate productionDate = LocalDate.of(2022, Month.JANUARY, 1);// 2022-06-13

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean rented;

    @NotNull
    private Long brandId;

    @NotNull
    private Long typeId;

    @NotNull
    private Long colorId;
//    private Long type; //car/motorbike/boat, etc
//    private Long color;
    //Em princípio só vamos precisar de um DTO com Long Id's em vez das classes Type, Brand e Color
}
