package com.kata.supermarketpricing;

import com.kata.supermarketpricing.strategy.FixedDiscountStrategy;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestFixedDiscountStrategy {

    @Test
    public void should_return_this_price_when_input_contains_this_data() {
        // given
        int quantite = 3;
        double discount = 0.4D;
        double initialCommandPrice = 100D;
        double unitPrice = 10D;
        FixedDiscountStrategy fixedDiscountStrategy = new FixedDiscountStrategy(quantite, discount);
        // when
        Double priceDetailCommande = fixedDiscountStrategy.apply(initialCommandPrice, unitPrice);
        // then
        assertThat(priceDetailCommande , is(118D));
    }
}
