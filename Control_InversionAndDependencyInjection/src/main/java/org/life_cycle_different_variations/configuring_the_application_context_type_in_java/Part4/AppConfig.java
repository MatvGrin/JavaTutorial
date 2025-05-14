package org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part4;

import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part2.MessageProvider;
import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part2.MessageRenderer;
import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part2.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;


@Configuration
@PropertySource(value = "message.properties")
public class AppConfig {
    @Autowired
    Environment env;

    @Bean
    @Lazy
    public MessageProvider messageProvider() {
//        return new ConfigurableMessageProvider(env.getProperty("message"));
        return null;
    }

    @Bean(name = "messageRenderer")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
