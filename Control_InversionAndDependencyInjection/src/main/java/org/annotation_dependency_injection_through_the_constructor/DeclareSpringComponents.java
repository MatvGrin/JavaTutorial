package org.annotation_dependency_injection_through_the_constructor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("annotation.xml");
        ctx.refresh();
        MessageProvider messageProvider = ctx.getBean("provider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());
    }
}
