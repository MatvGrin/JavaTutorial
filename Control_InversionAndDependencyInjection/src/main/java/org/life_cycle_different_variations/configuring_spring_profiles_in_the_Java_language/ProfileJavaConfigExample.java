package org.life_cycle_different_variations.configuring_spring_profiles_in_the_Java_language;

import org.life_cycle_different_variations.example_of_using_profiles_in_spring.Food;
import org.life_cycle_different_variations.example_of_using_profiles_in_spring.FoodProviderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;
import java.util.Map;

public class ProfileJavaConfigExample {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(KindergartenConfig.class, HighschoolConfig.class);

        FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }
        ctx.close();
//        Map<String, String> getenv = System.getenv();
//        for (Map.Entry<String, String> entry : getenv.entrySet()) {
//            System.out.println(entry.getKey() + " *** " + entry.getValue());
//        }
    }
}
//-Dspring.profiles.active=kindergarten
//-Dspring.profiles.active=highschool
//Run -> Edit Confi ->>
