package org.autowired.annotation_by_name;

import org.springframework.stereotype.Component;

@Component("aBreak")
public class Break {
    public void stop(){
        System.out.println("Car is stopping!");
    }
}
