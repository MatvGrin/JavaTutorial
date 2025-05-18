package org.life_cycle_different_variations.usage_of_factory_bean_and_factory_method_attributes.theChoiceBetweenInjectingDependencies;

import org.not_spring.MessageProvider;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello";
    }
}
