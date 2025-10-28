package org.life_cycle_different_variations.direct_access_to_the_spring_beans_component_factory;

import org.life_cycle_different_variations.fabrica_class_message_digest_factory_bean.MessageDigestFactoryBean;
import org.life_cycle_different_variations.fabrica_class_message_digest_factory_bean.MessageDigester;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class AccessingFactoryBeans {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-digest.xml");
        ctx.refresh();

        ctx.getBean("shaDigest", MessageDigester.class);
        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("shaDigest");
        try {
            MessageDigest shaDigest = factoryBean.getObject();
            System.out.println(shaDigest.digest("Helle world".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ctx.close();
    }
}
