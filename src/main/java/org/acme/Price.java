package org.acme;

import io.quarkus.resteasy.reactive.jackson.SecureField;

public class Price {

    @SecureField(rolesAllowed = "admin")
    public Float price;

    public String currency;

    public Price(String currency, Float price) {
        this.currency = currency;
        this.price = price;
    }

}
