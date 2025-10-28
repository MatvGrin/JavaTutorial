package org.autowired.annotation_by_constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("carByConstructor")
public class Car {
    private Engine petrolEngine;
    private Break aBreak;
    
    @Autowired
    public Car(@Qualifier("enginePetrol") Engine petrolEngine, Break aBreak) {
        this.petrolEngine = petrolEngine;
        this.aBreak = aBreak;
        System.out.println("Called engine and break by constructor");
    }

    void action(){
        petrolEngine.move();
        aBreak.stop();
    }


}
