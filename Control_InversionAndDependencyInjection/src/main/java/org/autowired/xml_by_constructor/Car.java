package org.autowired.xml_by_constructor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Car {
    private Engine petrolEngine;
    private Break aBreak;
    public Car() {
    }

    public Car(Engine dizelEngine) {
        this.petrolEngine = dizelEngine;
        System.out.println("Called engine by constructor");
    }

    public Car(Break aBreak) {
        this.aBreak = aBreak;
        System.out.println("Called break by constructor");
    }

    public Car(Engine petrolEngine, Break aBreak) {
        this.petrolEngine = petrolEngine;
        this.aBreak = aBreak;
        System.out.println("Called engine and break by constructor");
    }


    void action(){
        petrolEngine.move();
        aBreak.stop();
    }

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-03-new-04.xml");
        ctx.refresh();

        Car car = (Car) ctx.getBean("carConstructor");
        car.action();

        ctx.close();
    }

}
