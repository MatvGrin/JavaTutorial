package org.autowired.annotation_by_name;

import org.springframework.stereotype.Component;

@Component("dizelEngine")
public class DizelEngine implements Engine{
    @Override
    public void move() {
        System.out.println("Car uses dizel for engine!");
        System.out.println("Car is moving!");
    }
}
