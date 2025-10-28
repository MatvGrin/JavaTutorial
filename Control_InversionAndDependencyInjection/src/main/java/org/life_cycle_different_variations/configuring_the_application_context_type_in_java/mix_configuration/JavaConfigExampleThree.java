package org.life_cycle_different_variations.configuring_the_application_context_type_in_java.mix_configuration;

import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigExampleThree {
    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context-xml-02-mix-configuration.xml");
        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
