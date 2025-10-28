package org.autowired.annotation_by_name;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "org.autowired.annotation_by_name")
@Configuration
public class Demo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Demo.class);
        Car car = (Car) ctx.getBean("carByConstructor");
        car.action();
    }
}
