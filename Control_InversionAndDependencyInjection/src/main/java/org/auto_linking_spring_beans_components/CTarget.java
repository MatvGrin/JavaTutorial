package org.auto_linking_spring_beans_components;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CTarget {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-04-new.xml");
        ctx.refresh();

        System.out.println("\nUsing byType:\n");

        CTarget t = (CTarget) ctx.getBean("targetByType");

        ctx.close();
    }
}
