package com.kata.supermarketpricing;

import com.kata.supermarketpricing.strategy.TwoForThreeStrategy;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestTwoForThreeStrategy {

    @Test
    public void should_return_this_price_when_input_contains_this_data() {
        // given
        int quantite = 8;
        double initialCommandPrice = 100D;
        double unitPrice = 10D;
        TwoForThreeStrategy fixedDiscountStrategy = new TwoForThreeStrategy(quantite);
        // when
        Double priceDetailCommande = fixedDiscountStrategy.apply(initialCommandPrice, unitPrice);
        // then
        assertThat(priceDetailCommande , is(160D));
    }
}
