package org.introducing_simple_values;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {
    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-second.xml");
        ctx.refresh();
        InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
        System.out.println(simple);
        ctx.close();
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name = " + name + '\n' +
                "Age = " + age + '\n' +
                "Age in Seconds = " + ageInSeconds + '\n' +
                "Height = " + height + '\n' +
                "Is Programmer? = " + programmer;
    }
}
