package com.kata.supermarketpricing.strategy;

import java.util.function.BiFunction;

public class TwoForThreeStrategy  implements BiFunction<Double, Double,Double> {

    private Integer quantite;

    public TwoForThreeStrategy(Integer quantite) {
        this.quantite = quantite;
    }


    @Override
    public Double apply(Double initialCommandPrice , Double unitPrice) {
        double discountedPrice = (quantite / 3 * 2 + quantite % 3) * unitPrice;
        return initialCommandPrice + discountedPrice;
    }
}
