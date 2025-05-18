package org.life_cycle_different_variations.configuring_spring_profiles_in_the_Java_language;

import org.life_cycle_different_variations.abstraction_through_interfaces_environment_and_propertySource.AppProperty;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PlaceHolderDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-new.xml");
        ctx.refresh();
        AppProperty appProperty = ctx.getBean("appProperty", AppProperty.class);
        System.out.println("application.home: " + appProperty.getApplicationHome());
        System.out.println("user.home: " + appProperty.getUserHome());
        ctx.close();
    }
}
