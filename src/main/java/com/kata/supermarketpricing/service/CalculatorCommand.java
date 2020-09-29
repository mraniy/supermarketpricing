package com.kata.supermarketpricing.service;

import com.kata.supermarketpricing.model.DetailCommande;

import java.util.Optional;
import java.util.function.BiFunction;
public class CalculatorCommand {

    private Double totalCommandePrice = 0D;

    public Double proceed(DetailCommande detailCommande) {
        BiFunction<Double, Double, Double> strategy = detailCommande.getStrategy();
        totalCommandePrice = strategy.apply(totalCommandePrice,detailCommande.getProduct().getPrice());
        totalCommandePrice = Optional.ofNullable(detailCommande.getNext())
                .map(this::proceed)
                .orElseGet(() -> totalCommandePrice);
        return totalCommandePrice;
    }
}
