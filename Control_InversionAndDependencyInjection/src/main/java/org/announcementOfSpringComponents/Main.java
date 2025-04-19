package org.announcementOfSpringComponents;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml-announcement.xml");
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
    }
}
