package europcar.project.config;

import europcar.project.converters.UserConverterImp;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansInnit {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UserConverterImp UserConverterImp() {
        return new UserConverterImp(new ModelMapper());
    }

}
