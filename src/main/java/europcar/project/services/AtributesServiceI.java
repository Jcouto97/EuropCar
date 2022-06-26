package europcar.project.services;

import europcar.project.command.AtributeDto;

import java.util.List;

public interface AtributesServiceI {

    //brands
    List<AtributeDto> getBrands();

    AtributeDto addBrand(AtributeDto brand);

    void deleteBrand(Long id);

    AtributeDto updateBrand(Long id, AtributeDto brand);

    //types
    List<AtributeDto> getTypes();

    AtributeDto addType(AtributeDto typeDto);

    void deleteType(Long id);

    AtributeDto updateType(Long id, AtributeDto typeDto);

    //colors
    List<AtributeDto> getColors();

    AtributeDto addColor(AtributeDto colorDto);

    void deleteColor(Long id);

    AtributeDto updateColor(Long id, AtributeDto colorDto);
}
