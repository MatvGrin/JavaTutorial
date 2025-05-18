package org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part4;

import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part4"})
public class AppConfigTwo {
    @Autowired
    MessageProvider provider;
    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);
        return renderer;
    }
}
