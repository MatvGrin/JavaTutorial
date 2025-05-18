package org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part5;


import org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExampleThree {
    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigThree.class);
        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
