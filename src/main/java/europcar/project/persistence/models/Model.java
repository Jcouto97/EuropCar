package europcar.project.persistence.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Entity
@NoArgsConstructor //porque??
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    @Size(min = 2, message = "Model name should have at least 2 characters")

    @Column(nullable = false, unique = true, updatable = false)
    private String name;


    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles = new HashSet<>();

}
