package org.autowired.xml_by_constructor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Car {
    private Engine dizelEngine;
    private Break aBreak;
    public Car() {
    }

    public void setDizelEngine(Engine dizelEngine) {
        this.dizelEngine = dizelEngine;
        System.out.println("Called engine by set");
    }

    public void setaBreak(Break aBreak) {
        this.aBreak = aBreak;
        System.out.println("Called break by set");
    }

    void action(){
        dizelEngine.move();
        aBreak.stop();
    }

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-03-new-03.xml");
        ctx.refresh();

        Car car = (Car) ctx.getBean("carByName");
        car.action();

        ctx.close();
    }

}
