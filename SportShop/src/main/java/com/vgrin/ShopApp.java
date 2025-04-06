package com.vgrin;

import com.vgrin.service.BasketBallProvider;
import com.vgrin.service.FootballProvider;
import com.vgrin.service.ShopService;
import com.vgrin.service.TennisProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopApp {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spr.xml");
        ShopService shopService = ctx.getBean(ShopService.class);

        shopService.showAll();
    }
}
