package europcar.project.services;

import europcar.project.command.VehicleDto;
import europcar.project.command.VehicleUpdateDto;
import europcar.project.converters.VehicleConverterImpl;
import europcar.project.exceptions.*;
import europcar.project.persistence.models.Vehicle;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.*;

import europcar.project.persistence.models.VehicleAtributes.Brand;
import europcar.project.persistence.models.VehicleAtributes.Color;
import europcar.project.persistence.models.VehicleAtributes.Type;
import europcar.project.persistence.repositories.BrandRepository;
import europcar.project.persistence.repositories.ColorRepository;
import europcar.project.persistence.repositories.TypeRepository;
import europcar.project.persistence.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImp implements VehicleServiceI {

    private final VehicleRepository vehicleRepository;
    private final VehicleConverterImpl vehicleConverter;
    private final BrandRepository brandRepository;
    private final TypeRepository typeRepository;
    private final ColorRepository colorRepository;

    //private final ColorRepository colorRepository;

    @Override
    public List<VehicleDto> getVehicles() {
        return this.vehicleConverter.entityListToDtoList(
                this.vehicleRepository.findAll());
    }

    @Override
    public VehicleDto getVehicleById(Long id) {
        Vehicle vehicleById = this.vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND));
        return this.vehicleConverter.entityToDto(vehicleById);
    }

    @Override
    public List<VehicleDto> getVehicleByBrand(Long brandId) {
        Brand brand = this.brandRepository.findById(brandId)
                .orElseThrow(() -> new AtributeNotFoundException(ATRIBUTE_NOT_FOUND));
        return this.vehicleConverter.entityListToDtoList(
                this.vehicleRepository.findAllByBrand(brand));
    }

    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleConverter.dtoToEntity(vehicleDto);
        Brand brand = this.brandRepository.findById(vehicleDto.getBrandId())
                .orElseThrow(() -> new AtributeNotFoundException(ATRIBUTE_NOT_FOUND));
        Type type = this.typeRepository.findById(vehicleDto.getTypeId())
                .orElseThrow(() -> new AtributeNotFoundException(ATRIBUTE_NOT_FOUND));

        Color color = this.colorRepository.findById(vehicleDto.getColorId())
                .orElseThrow(() -> new AtributeNotFoundException(ATRIBUTE_NOT_FOUND));

        vehicle.setBrand(brand);
        brand.addVehicle(vehicle);

        vehicle.setType(type);
        type.addVehicle(vehicle);

        vehicle.setColor(color);
        color.addVehicle(vehicle);

        return vehicleConverter.entityToDto(vehicleRepository.save(vehicle));
    }

    @Override
    public VehicleDto updateVehicle(Long id, VehicleUpdateDto vehicleUpdateDto) {
        Vehicle vehicle = vehicleConverter.updateDtoToEntity(vehicleUpdateDto, vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND)));
        return vehicleConverter.entityToDto(vehicleRepository.save(vehicle));
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = this.vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND));

        if (vehicle.isRented()) throw new RentingException(VEHICLE_RENTED);
        this.vehicleRepository.delete(vehicle);
    }
}
