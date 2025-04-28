package org.autowired.annotation;

import org.springframework.stereotype.Component;

@Component("engine")
public class Engine {
    public void move(){
        System.out.println("Car is moving!");
    }
}
