package org.autowired.annotation_by_name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("carByConstructor")
public class Car {
//    @Autowired
//    @Qualifier("enginePetrol")
    private Engine engine;
//    @Autowired
    private Break aBreak;
//    public Car() {
//    }
    @Autowired
    public Car(@Qualifier("enginePetrol") Engine engine, Break aBreak) {
        this.engine = engine;
        this.aBreak = aBreak;
    }

//    @Autowired
//    @Qualifier("enginePetrol")
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//        System.out.println("Called engine by set");
//    }
//
//    @Autowired
//    public void setaBreak(Break aBreak) {
//        this.aBreak = aBreak;
//        System.out.println("Called break by set");
//    }

    void action(){
        engine.move();
        aBreak.stop();
    }

}
