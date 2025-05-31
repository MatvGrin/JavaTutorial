package org.introduction_to_AOP_with_spring.factory;

public class CarFactory {

    public CarFactory() {
    }

    public Car getCar(String name) {
        return switch (name) {
            case "mers" -> new Mers();
            case "bmv" -> new BMW();
            case "chev" -> new Chevrolet();
            default -> null;
        };
    }
}
