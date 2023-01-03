package com.demo.advertising.general_management.services.models;

public class PaymentByWebsite implements PaymentStrategy {

    private Website paypal;

    @Override
    public void selectPaymentMethod(){
        paypal = new Website();
    }

    @Override
    public void pay(){
        throw new RuntimeException("Paid with Website!");
    }
}
