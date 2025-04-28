package org.resolve_dependencies;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.*;

@Component("johnMayer")
@DependsOn("gopher")
public class Singer implements ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    private Guitar guitar;

    public void sing(){
        guitar = ctx.getBean("gopher", Guitar.class);
        guitar.sing();
    }
}
