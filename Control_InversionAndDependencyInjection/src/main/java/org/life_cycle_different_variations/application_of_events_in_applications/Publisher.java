package org.life_cycle_different_variations.application_of_events_in_applications;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void publish(String message, Book book) {
        ctx.publishEvent(new MessageEvent(this, message, book));
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context-xml-application.xml");
        Publisher pub = (Publisher) ctx.getBean("publisher");
        pub.publish("I send an SOS to the world ... ", new Book("Hobbit", 1960));
        pub.publish(" ... I hope that someone gets my ... ", new Book("Lolipop", 1940));
        pub.publish(" ... Message in а bottle", new Book("The ring of war", 1980));
    }
}
