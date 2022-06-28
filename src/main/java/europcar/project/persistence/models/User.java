package europcar.project.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor //porque??
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Table(name = "users")
public class User implements UserDetails {
    //commit
    //sdsf
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    private String name;
    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false, unique = true)
    private String driversLicense;
    private boolean isRenting;

    @JsonIgnore //para problema de recursividade
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.DETACH)
    private List<Rental> rentals;

    //metodo no controller para vir buscar aqui ao user
    public void addRental(Rental rental) {
        //funçao verifica se isrenting true
        this.rentals.add(rental);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
