package europcar.project.persistence.repositories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository

public class JPARepository {

    private String string = "HELLO";

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
