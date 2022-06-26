package europcar.project.services;

import europcar.project.command.AtributeDto;

import java.util.List;

public interface AtributesServiceI {
    List<AtributeDto> getBrands();

    AtributeDto addBrand(AtributeDto brand);

    void deleteBrand(Long id);

    AtributeDto updateBrand(Long id, AtributeDto brand);
}
