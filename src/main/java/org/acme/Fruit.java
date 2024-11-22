package org.acme;

import java.util.List;

public class Fruit {

    public String name;
    

    public List<Price> prices;

    public Fruit(String name, Float price) {
        this.name = name;
        this.prices = List.of(new Price("USD", price));
    }

}
