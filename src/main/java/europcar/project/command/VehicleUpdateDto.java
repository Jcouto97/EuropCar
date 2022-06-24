package europcar.project.command;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Month;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleUpdateDto {

    private Long id;
    private String name;

    @NotEmpty
    @Size(min = 2, message = "License plate should have at least 2 characters")
    private String licensePlate;

    private Long rentalId;
    private String type; //car/motorbike/boat, etc
    private String model;
    private String color;
    private LocalDate productionDate;// 2022-06-13
    private LocalDate registrationDate;
    private String avatarUrl;

}
