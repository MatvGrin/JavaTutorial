package org.autowired.annotation;

import org.configuration.HelloWorldConfiguration;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

@ComponentScan(basePackages = "org.autowired.annotation")
@Configuration
public class Demo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Demo.class);
        Car car = (Car) ctx.getBean("carByType");
        car.action();
    }
}
