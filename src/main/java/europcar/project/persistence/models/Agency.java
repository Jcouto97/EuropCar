package europcar.project.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "agencies")

public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String name;

    @Column(nullable = false, unique = true, updatable = false)
    private String location;

    @JsonIgnore //para problema de recursividade
    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Rental> rentals;
}
