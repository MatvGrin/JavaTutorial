package org.autowired.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("carByType")
public class Car {
    private Engine engine;
    private Break aBreak;

    public Car() {
    }
    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println("Called engine by set");
    }
    @Autowired
    public void setaBreak(Break aBreak) {
        this.aBreak = aBreak;
        System.out.println("Called break by set");
    }

    void action(){
        engine.move();
        aBreak.stop();
    }

}
