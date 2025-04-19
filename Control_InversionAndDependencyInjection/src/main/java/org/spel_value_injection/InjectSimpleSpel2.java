package org.spel_value_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("injectSimpleSpel2")
public class InjectSimpleSpel2 {
    @Value("#{injectSimpleConfig.name}")
    private String name;
    @Value("#{injectSimpleConfig.age + 1}")
    private int age;
    @Value("#{injectSimpleConfig.height}")
    private float height;
    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;
    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;

    @Override
    public String toString() {
        return "InjectSimpleSpel2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("spel-config2.xml");
        ctx.refresh();
        InjectSimpleSpel2 simple = (InjectSimpleSpel2) ctx.getBean("injectSimpleSpel2");
        System.out.println(simple);
        ctx.close();
    }

}
