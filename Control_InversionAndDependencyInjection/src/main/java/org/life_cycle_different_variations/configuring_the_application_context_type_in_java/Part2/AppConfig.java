package org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part2;

import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1.*;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    @Bean
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider();
    }
    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}

