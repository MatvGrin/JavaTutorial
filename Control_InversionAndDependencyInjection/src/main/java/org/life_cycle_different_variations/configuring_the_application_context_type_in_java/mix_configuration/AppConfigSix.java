package org.life_cycle_different_variations.configuring_the_application_context_type_in_java.mix_configuration;

import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1.MessageProvider;
import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1.ConfigurableMessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigSix {
    @Bean
    public MessageProvider messageRenderer(){
        return new ConfigurableMessageProvider("Love on the weekend");
    }
}
