package org.life_cycle_different_variations.fabrica_class_message_digest_factory_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MessageDigesterConfigDemo {
    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(MessageDigesterConfig.class);
        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");
        ctx.close();
    }
}
