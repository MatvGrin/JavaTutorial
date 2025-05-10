package org.life_cycle_different_variations.applying_the_bean_name_aware_interface;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NamedSingerDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-life-cycle-aware.xml");
        ctx.refresh();

        NamedSinger bean = (NamedSinger) ctx.getBean("johnMayer");
        bean.sing();

        ctx.close();
    }
}
