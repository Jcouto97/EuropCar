package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import europcar.project.persistence.models.Model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class VehicleDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;

    @Column(unique = true, updatable = false)
    private String licensePlate;

    private Long rentalId;
    private String type; //car/motorbike/boat, etc
    private Model model;
    private String color;
    private Long numOfSeats;
    private Long pricePerHour;
    private LocalDate productionDate;// 2022-06-13
    private LocalDate registrationDate = LocalDate.of(2022, Month.JUNE, 23);


}
