package org.naming_spring_beans_components;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class BeanNamingTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-02.xml");
        ctx.refresh();
        Map<String,String> beans = ctx.getBeansOfType(String.class);
        beans.entrySet().forEach(b -> System.out.println(b.getKey()));
        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        ctx.close();
    }
//    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("app-context-01.xml");
//        ctx.refresh();
//        Map<String,String> beans = ctx.getBeansOfType(String.class);
//        beans.entrySet().stream()
//                .forEach(b -> System.out.println(b.getKey()) );
//        ctx.close();
//    }
}
