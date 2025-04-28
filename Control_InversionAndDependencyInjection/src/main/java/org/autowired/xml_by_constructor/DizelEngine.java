package org.autowired.xml_by_constructor;

public class DizelEngine implements Engine {
    @Override
    public void move() {
        System.out.println("Car uses dizel for engine!");
        System.out.println("Car is moving!");
    }
}
