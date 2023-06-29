package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class NewConfig {

@Bean
@Primary
    public String welcome(){
        return "Welcome to Cydeo";
    }

    @Bean
    public String practice(){
    return "Spring Core Practice";
    }
}
