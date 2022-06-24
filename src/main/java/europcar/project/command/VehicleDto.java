package europcar.project.command;

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

    private Long id;

    private String name;

    @Column(unique = true, updatable = false)
    private String licensePlate;

    private Long rentalId;
    private String type; //car/motorbike/boat, etc
    private String model;
    private String color;
    private LocalDate productionDate;// 2022-06-13
    private LocalDate registrationDate = LocalDate.of(2022, Month.JUNE, 23);
    private String avatarUrl;


}
