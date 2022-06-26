package europcar.project.services;

import europcar.project.command.AtributeDto;
import europcar.project.converters.AtributeConverterImp;
import europcar.project.exceptions.AtributeAttachedException;
import europcar.project.exceptions.AtributeNotFoundException;
import europcar.project.persistence.models.VehicleAtributes.Brand;
import europcar.project.persistence.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.ATRIBUTE_ATTACHED;
import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.ATRIBUTE_NOT_FOUND;

@Service
@AllArgsConstructor
public class AtributesServiceImp implements AtributesServiceI {
    private final BrandRepository brandRepository;
    private final AtributeConverterImp converter;

    @Override
    public List<AtributeDto> getBrands() {
        return this.converter.entityListToDtoList(
                this.brandRepository.findAll());
    }

    @Override
    public AtributeDto addBrand(AtributeDto brandDto) {
        return this.converter.entityToDto(
                this.brandRepository.save(
                        this.converter.dtoToEntity(brandDto)));
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
        return this.converter.entityToDto(this.brandRepository.save(brandToUpdate));
    }
}
