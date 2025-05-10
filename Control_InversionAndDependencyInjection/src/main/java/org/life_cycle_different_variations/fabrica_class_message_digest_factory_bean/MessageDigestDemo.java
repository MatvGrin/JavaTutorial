package org.life_cycle_different_variations.fabrica_class_message_digest_factory_bean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-digest.xml");
        ctx.refresh();

        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello World!");
        ctx.close();
    }
}
