package org.conf_spring;

import org.not_spring.HelloWorldMessageProvider;
import org.not_spring.MessageProvider;
import org.not_spring.MessageRenderer;
import org.not_spring.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;

public class HelloWorldConfiguration {

    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer renderer(MessageProvider provider) {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);
        return renderer;
    }
}
