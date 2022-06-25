package europcar.project.config;

import europcar.project.converters.AgencyConverterImp;
import europcar.project.converters.UserConverterImp;
import europcar.project.persistence.models.Rental;
import europcar.project.persistence.models.User;
import europcar.project.persistence.models.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansInnit {
   @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
