package org.introduction_to_AOP_with_spring.factory;

public class Chevrolet implements Car{
    @Override
    public void drive() {
        System.out.println("I am Chevrolet");
    }
}
