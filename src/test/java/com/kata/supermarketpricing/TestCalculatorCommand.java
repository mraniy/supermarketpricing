package com.kata.supermarketpricing;

import com.kata.supermarketpricing.model.DetailCommande;
import com.kata.supermarketpricing.model.Product;
import com.kata.supermarketpricing.service.CalculatorCommand;
import com.kata.supermarketpricing.strategy.FixedDiscountStrategy;
import com.kata.supermarketpricing.strategy.TwoForThreeStrategy;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestCalculatorCommand {

    @Test
    public void should_return_this_data_when_we_have_this_input() {
        // given
        CalculatorCommand commande = new CalculatorCommand();
        Product gilette = new Product("Gilette", 20D);
        Product colgate = new Product("Colgatte", 10D);
        Product febreeze = new Product("Febreeze", 30D);
        Integer quantiteGilette = 5;
        Integer quantiteColgate = 3;
        Integer quantiteFebreeze = 8;
        DetailCommande detailCommandeColgate = new DetailCommande(colgate, quantiteColgate,null, new TwoForThreeStrategy(quantiteColgate));
        DetailCommande detailCommandeFebreeze = new DetailCommande(febreeze, quantiteFebreeze, null, new FixedDiscountStrategy(quantiteFebreeze, 0.2D));
        DetailCommande detailCommandeGilette = new DetailCommande(gilette, quantiteGilette, null, new TwoForThreeStrategy(quantiteGilette));
        detailCommandeColgate.setNext(detailCommandeFebreeze);
        detailCommandeFebreeze.setNext(detailCommandeGilette);
        // when
        Double totalPrice = commande.proceed(detailCommandeColgate);
        // then
        // 80+20+192
        assertThat(totalPrice , is(292D));
    }
}
