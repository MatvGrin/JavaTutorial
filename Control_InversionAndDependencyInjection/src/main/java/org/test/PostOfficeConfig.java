package org.test;

import org.life_cycle_different_variations.application_of_events_in_applications.MessageEvent;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = "org.test")
public class PostOfficeConfig {
    @Scope("prototype")
    @Bean(initMethod = "initMail", destroyMethod = "destroyMail")
    public Mail mail(){
        return new Mail();
    }

}
