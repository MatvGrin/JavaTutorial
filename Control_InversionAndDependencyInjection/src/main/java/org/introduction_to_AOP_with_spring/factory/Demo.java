package org.introduction_to_AOP_with_spring.factory;

public class Demo {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car1 = carFactory.getCar("mers");
        Car car2 = carFactory.getCar("chev");
        Car car3 = carFactory.getCar("bmv");
        car1.drive();
        car2.drive();
        car3.drive();
    }
}
