package org.configuring_dependency_injection_through_a_field;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
    @Value("John Mayer")
    private String name;
    @Value("39")
    private int age;
    @Value("1.92")
    private float height;
    @Value("false")
    private boolean programmer;
    @Value("1241401112")
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-second.xml");
        ctx.refresh();
        InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
        System.out.println(simple);
        ctx.close();
    }

    public String toString() {
        return "Name = " + name + '\n' +
                "Age = " + age + '\n' +
                "Age in Seconds = " + ageInSeconds + '\n' +
                "Height = " + height + '\n' +
                "Is Programmer? = " + programmer;
    }
}
