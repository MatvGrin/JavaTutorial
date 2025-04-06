package com.vgrin.service;

import org.springframework.stereotype.Component;

public class TennisProvider implements GoodsProvider {
    @Override
    public void provide() {
        System.out.println("Provide tennis equipment");
    }
}
