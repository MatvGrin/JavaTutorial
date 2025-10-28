package org.introduction_to_AOP_with_spring.factory;

public class BMW implements Car{
    @Override
    public void drive() {
        System.out.println("I am BMW");
    }
}
