package org.naming_beans_components_using_annotations_in_configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

public class AnnotatedBeanNaming {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-annotated-01.xml");
        ctx.refresh();

        Map<String,Singer> beans = ctx.getBeansOfType(Singer.class);
        beans.entrySet().forEach(b ->
                System.out.println("id: "+ b.getKey()));
        ctx.close();
    }
}
