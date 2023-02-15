package ng.temire.phastmoney.robot.apocalypse.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import static ng.temire.phastmoney.robot.apocalypse.util.Constants.ROBOTS_URL;

/**
 * @author Temire Emmanuel
 * @created 12/02/2023 - 16:46
 */
@Configuration
public class BeanConfigs {
    @Bean
    public ModelMapper modelMapper() {return new ModelMapper();}
    @Bean
    public WebClient webClient(){ return WebClient.create(ROBOTS_URL);}
}
