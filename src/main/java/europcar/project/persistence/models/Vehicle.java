package europcar.project.persistence.models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "vehicle")

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;
    private String name;

    @Column(nullable = false, unique = true, updatable = false)
    private String licensePlate;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Rental> rentals;

    private String type; //car/motorbike/boat, etc
    private String model;
    private String color;
    private LocalDate productionDate;// 2022-06-13
    private LocalDate registrationDate;// 2022-06-13
    private String avatarUrl;


}
