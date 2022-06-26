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

    //brands
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

    //types
    @GetMapping("/type")
    public List<AtributeDto> getTypes() {
        return this.atributesService.getTypes();
    }

    @PostMapping("/type")
    public AtributeDto addType(@Valid @RequestBody AtributeDto typeDto) {
        return this.atributesService.addType(typeDto);
    }

    @DeleteMapping("/type/{id}")
    public void deleteType(@PathVariable("id") Long id) {
        this.atributesService.deleteType(id);
    }

    @PutMapping("/type/{id}")
    public AtributeDto updateType(@PathVariable("id") Long id, @Valid @RequestBody AtributeDto typeDto) {
        return this.atributesService.updateType(id, typeDto);
    }

    //colors

    @GetMapping("/color")
    public List<AtributeDto> getColors() {
        return this.atributesService.getColors();
    }

    @PostMapping("/color")
    public AtributeDto addColor(@Valid @RequestBody AtributeDto colorDto) {
        return this.atributesService.addColor(colorDto);
    }

    @DeleteMapping("/color/{id}")
    public void deleteColor(@PathVariable("id") Long id) {
        this.atributesService.deleteColor(id);
    }

    @PutMapping("/color/{id}")
    public AtributeDto updateColor(@PathVariable("id") Long id, @Valid @RequestBody AtributeDto colorDto) {
        return this.atributesService.updateColor(id, colorDto);
    }
}
