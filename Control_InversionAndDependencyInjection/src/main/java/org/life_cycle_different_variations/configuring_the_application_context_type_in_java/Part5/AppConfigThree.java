package org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part5;

import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part2.StandardOutMessageRenderer;
import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part2.MessageProvider;
import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part2.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfigFour.class)
public class AppConfigThree {
    @Autowired
    MessageProvider provider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);
        return renderer;
    }
}
