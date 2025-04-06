package com.vgrin.service;

import org.springframework.stereotype.Component;

public class BasketBallProvider implements GoodsProvider {

    @Override
    public void provide() {
        System.out.println("Provide basketball equipment");
    }
}
