package org.life_cycle_different_variations.example_of_using_profiles_in_spring;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class ProfileXmlConfigExample {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:*-config-profile.xml");
        ctx.refresh();

        FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }
        ctx.close();
    }
}
