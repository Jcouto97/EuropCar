package europcar.project.services;

import europcar.project.command.AtributeDto;
import europcar.project.converters.BrandConverterImp;
import europcar.project.converters.ColorConverterImp;
import europcar.project.converters.TypeConverterImp;
import europcar.project.exceptions.AtributeAttachedException;
import europcar.project.exceptions.AtributeNotFoundException;
import europcar.project.persistence.models.VehicleAtributes.Brand;
import europcar.project.persistence.models.VehicleAtributes.Color;
import europcar.project.persistence.models.VehicleAtributes.Type;
import europcar.project.persistence.repositories.BrandRepository;
import europcar.project.persistence.repositories.ColorRepository;
import europcar.project.persistence.repositories.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.ATRIBUTE_ATTACHED;
import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.ATRIBUTE_NOT_FOUND;

@Service
@AllArgsConstructor
public class AtributesServiceImp implements AtributesServiceI {
    private final BrandRepository brandRepository;
    private final TypeRepository typeRepository;
    private final BrandConverterImp brandConverter; //brands
    private final TypeConverterImp typeConverter;
    private final ColorConverterImp colorConverter;
    private final ColorRepository colorRepository;


    //brands
    @Override
    public List<AtributeDto> getBrands() {
        return this.brandConverter.entityListToDtoList(
                this.brandRepository.findAll());
    }

    @Override
    public AtributeDto addBrand(AtributeDto brandDto) {
        return this.brandConverter.entityToDto(
                this.brandRepository.save(
                        this.brandConverter.dtoToEntity(brandDto)));
    }

    @Override
    public void deleteBrand(Long id) {
        Brand brand = this.brandRepository.findById(id)
                .orElseThrow(() -> new AtributeNotFoundException(ATRIBUTE_NOT_FOUND));

        if (!brand.getVehicles().isEmpty()) throw new AtributeAttachedException(ATRIBUTE_ATTACHED);
        this.brandRepository.delete(brand);
    }

    @Override
    public AtributeDto updateBrand(Long id, AtributeDto brandDto) {
        Brand brandToUpdate = this.brandRepository.findById(id)
                .orElseThrow(() -> new AtributeNotFoundException(ATRIBUTE_NOT_FOUND));
        brandToUpdate.setAtribute(brandDto.getAtribute());
        return this.brandConverter.entityToDto(this.brandRepository.save(brandToUpdate));
    }

    //types

    @Override
    public List<AtributeDto> getTypes() {
        return this.typeConverter.entityListToDtoList(this.typeRepository.findAll());
    }

    @Override
    public AtributeDto addType(AtributeDto typeDto) {
        return this.typeConverter.entityToDto(this.typeRepository.save(this.typeConverter.dtoToEntity(typeDto)));
    }

    @Override
    public void deleteType(Long id) {
        Type type = this.typeRepository.findById(id).orElseThrow(() -> new AtributeNotFoundException(ATRIBUTE_NOT_FOUND));

        if (!type.getVehicles().isEmpty()) throw new AtributeAttachedException(ATRIBUTE_ATTACHED);
        this.typeRepository.delete(type);
    }

    @Override
    public AtributeDto updateType(Long id, AtributeDto typeDto) {
        Type typeToUpdate = this.typeRepository.findById(id).orElseThrow(() -> new AtributeNotFoundException(ATRIBUTE_NOT_FOUND));

        typeToUpdate.setAtribute(typeDto.getAtribute());
        return this.typeConverter.entityToDto(this.typeRepository.save(typeToUpdate));
    }

    //colors
    @Override
    public List<AtributeDto> getColors() {
        return this.colorConverter.entityListToDtoList(this.colorRepository.findAll());
    }

    @Override
    public AtributeDto addColor(AtributeDto colorDto) {
        return this.colorConverter.entityToDto(this.colorRepository.save(this.colorConverter.dtoToEntity(colorDto)));
    }

    @Override
    public void deleteColor(Long id) {
        Color color = this.colorRepository.findById(id).orElseThrow(() -> new AtributeNotFoundException(ATRIBUTE_NOT_FOUND));

        if (!color.getVehicles().isEmpty()) throw new AtributeAttachedException(ATRIBUTE_ATTACHED);
        this.colorRepository.delete(color);
    }

    @Override
    public AtributeDto updateColor(Long id, AtributeDto colorDto) {
        Color colorToUpdate = this.colorRepository.findById(id).orElseThrow(() -> new AtributeNotFoundException(ATRIBUTE_NOT_FOUND));

        colorToUpdate.setAtribute(colorDto.getAtribute());
        return this.colorConverter.entityToDto(this.colorRepository.save(colorToUpdate));
    }

}
