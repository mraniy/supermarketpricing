package com.kata.supermarketpricing.strategy;

import java.util.function.BiFunction;

public class FixedDiscountStrategy implements BiFunction<Double,Double,Double> {
    private Integer quantite;

    private Double discount;

    public FixedDiscountStrategy(Integer quantite, Double discount) {
        this.quantite = quantite;
        this.discount = discount;
    }


    public Double apply(Double initialCommandPrice, Double unitPrice) {
        double discountedPrice = quantite * unitPrice * (1 - discount);
        return initialCommandPrice + discountedPrice;
    }
}
