package com.vgrin.config;

import com.vgrin.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfig {

    @Bean
    public FootballProvider footballProvider() {
        return new FootballProvider();
    }

    @Bean
    public BasketBallProvider basketBallProvider() {
        return new BasketBallProvider();
    }

    @Bean
    public TennisProvider tennisProvider() {
        return new TennisProvider();
    }

    @Bean
    public ShopService shopService() {
        return new ShopService(footballProvider(), basketBallProvider(), tennisProvider());
    }
}
