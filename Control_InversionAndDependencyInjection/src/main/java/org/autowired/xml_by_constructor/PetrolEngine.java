package org.autowired.xml_by_constructor;

public class PetrolEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Car uses petrol for engine!");
        System.out.println("Car is moving!");
    }
}
