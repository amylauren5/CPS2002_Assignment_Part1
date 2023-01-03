package com.demo.advertising.general_management.services.models;

public class PaymentByCard implements PaymentStrategy {
    private Card card;

    @Override
    public void selectPaymentMethod(){
        card = new Card();
    }

    @Override
    public void pay() {
        throw new RuntimeException("Paid with Card!");
    }

}
