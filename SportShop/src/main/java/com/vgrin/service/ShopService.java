package com.vgrin.service;

public class ShopService {

    private final GoodsProvider footballProvider;
    private final GoodsProvider basketBallProvider;
    private final GoodsProvider tennisProvider;

    public ShopService(FootballProvider footballProvider, BasketBallProvider basketBallProvider, TennisProvider tennisProvider) {
        this.footballProvider = footballProvider;
        this.basketBallProvider = basketBallProvider;
        this.tennisProvider = tennisProvider;
    }

    public void showAll() {
        footballProvider.provide();
        basketBallProvider.provide();
        tennisProvider.provide();
    }

}
