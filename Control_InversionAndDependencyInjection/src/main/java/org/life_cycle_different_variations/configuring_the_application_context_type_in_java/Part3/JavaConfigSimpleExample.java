package org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part3;

import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1.*;
import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part2.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class JavaConfigSimpleExample {
    @Configuration
    static class AppConfigOne{
        @Bean
        public MessageProvider messageProvider(){
            return new ConfigurableMessageProvider("message");
        }
        @Bean
        public MessageRenderer messageRenderer(){
            MessageRenderer renderer = new StandardOutMessageRenderer();
            renderer.setMessageProvider(messageProvider() );
            return renderer;
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
