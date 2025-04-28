package org.autowired.auto_ln;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Car {
    private Engine engine;
    private Break aBreak;

    public Car() {
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println("Called engine by set");
    }

    public void setaBreak(Break aBreak) {
        this.aBreak = aBreak;
        System.out.println("Called break by set");
    }

    void action(){
        engine.move();
        aBreak.stop();
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-03-new-02.xml");
        ctx.refresh();

        Car car = (Car) ctx.getBean("carByType");
        car.action();

        ctx.close();
    }
}
