package org.life_cycle_different_variations.usage_of_factory_bean_and_factory_method_attributes;

import org.life_cycle_different_variations.fabrica_class_message_digest_factory_bean.MessageDigester;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryDemo {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-contextxml.xml");
        ctx.refresh();

        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello World!");
        ctx.close();
    }
}
