package org.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PostOfficeConfig.class);
        PostOffice postOffice = ctx.getBean("postOffice", PostOffice.class);
        postOffice.handle();
        ctx.close();
    }
}
