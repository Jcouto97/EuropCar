package europcar.project.persistence.repositories;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Populate<T> {
    private List<T> list = new ArrayList<>();
}
