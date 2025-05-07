package org.life_cycle_different_variations.life_cycle_annotation_bean;

import org.life_cycle_different_variations.life_cycle.Singer;
import static org.life_cycle_different_variations.life_cycle.Singer.getBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

@Configuration
public class SingerConfigDemo {
    @Lazy
    @Bean(initMethod = "init")
    Singer singerOne(){
        Singer singerOne = new Singer();
        singerOne.setName("John Mayer");
        singerOne.setAge(39);
        return singerOne;
    }

    @Lazy
    @Bean(initMethod = "init")
    Singer singerTwo(){
        Singer singerTwo = new Singer();
        singerTwo.setAge(72);
        return singerTwo;
    }

    @Lazy
    @Bean(initMethod = "init")
    Singer singerThree(){
        Singer singerThree = new Singer();
        singerThree.setName("John Butler");
        return singerThree;
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfigDemo.class);
        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);
        ctx.close();
    }
}
