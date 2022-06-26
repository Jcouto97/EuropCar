package europcar.project.controllers;

import europcar.project.command.AtributeDto;
import europcar.project.services.AtributesServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/atributes")
public class AtributeController {
    private final AtributesServiceI atributesService;

    @GetMapping("/brand")
    public List<AtributeDto> getBrands() {
        return this.atributesService.getBrands();
    }

    @PostMapping("/brand")
    public AtributeDto addBrand(@Valid @RequestBody AtributeDto brandDto) {
        return this.atributesService.addBrand(brandDto);
    }

    @DeleteMapping("/brand/{id}")
    public void deleteBrand(@PathVariable("id") Long id) {
        this.atributesService.deleteBrand(id);
    }

    @PutMapping("/brand/{id}")
    public AtributeDto updateBrand(@PathVariable("id") Long id, @Valid @RequestBody AtributeDto brandDto) {
        return this.atributesService.updateBrand(id, brandDto);
    }
}
