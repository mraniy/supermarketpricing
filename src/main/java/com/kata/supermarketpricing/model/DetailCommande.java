package com.kata.supermarketpricing.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.BiFunction;

@Data
@AllArgsConstructor
public class DetailCommande {

    Product product;

    Integer quantite;

    DetailCommande next;

    BiFunction<Double,Double,Double> strategy;



}
