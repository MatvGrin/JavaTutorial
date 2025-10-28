package org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part4;

import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1.MessageProvider;
import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1.MessageRenderer;
import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "message.properties")
public class AppConfigOne {
    @Autowired
    Environment env;

    @Bean
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
