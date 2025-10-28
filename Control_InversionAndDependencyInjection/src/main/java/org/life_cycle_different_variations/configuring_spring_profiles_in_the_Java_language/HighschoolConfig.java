package org.life_cycle_different_variations.configuring_spring_profiles_in_the_Java_language;

import org.life_cycle_different_variations.example_of_using_profiles_in_spring.FoodProviderService;
import org.life_cycle_different_variations.example_of_using_profiles_in_spring.highschool.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("highschool")
public class HighschoolConfig {
    @Bean
    public FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}
