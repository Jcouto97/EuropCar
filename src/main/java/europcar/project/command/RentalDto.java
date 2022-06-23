package europcar.project.command;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class RentalDto {
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
