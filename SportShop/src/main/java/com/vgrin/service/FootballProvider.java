package com.vgrin.service;

import org.springframework.stereotype.Component;

public class FootballProvider implements GoodsProvider {

    @Override
    public void provide() {
        System.out.println("Provide football equipment");
    }
}
