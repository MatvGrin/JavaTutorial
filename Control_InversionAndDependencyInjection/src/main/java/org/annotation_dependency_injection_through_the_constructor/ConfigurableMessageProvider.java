package org.annotation_dependency_injection_through_the_constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {

    private final String message;

    @Autowired
    public ConfigurableMessageProvider(@Qualifier("message") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
