package org.introduction_to_AOP_with_spring.factory;

public class Mers implements Car{
    @Override
    public void drive() {
        System.out.println("I am Mersedes");
    }
}
