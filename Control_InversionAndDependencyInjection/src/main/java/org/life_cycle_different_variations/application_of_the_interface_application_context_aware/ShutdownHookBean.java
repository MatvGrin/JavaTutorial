package org.life_cycle_different_variations.application_of_the_interface_application_context_aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {
    private ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
        System.out.println(applicationContext.getBean("auto"));
        if (ctx instanceof GenericApplicationContext){
            ((GenericApplicationContext) ctx).registerShutdownHook();
        }
    }
}
