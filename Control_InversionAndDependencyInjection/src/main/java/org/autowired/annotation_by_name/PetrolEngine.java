package org.autowired.annotation_by_name;

import org.springframework.stereotype.Component;

@Component("enginePetrol")
public class PetrolEngine implements Engine{
    @Override
    public void move() {
        System.out.println("Car uses petrol for engine!");
        System.out.println("Car is moving!");
    }
}
