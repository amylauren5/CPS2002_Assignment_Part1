package com.demo.advertising.general_management.services.models;

public class PaymentByCardStrategy implements PaymentStrategy {

    @Override
    public void selectPaymentMethod() {
        throw new RuntimeException("Selected card payment method!");
    }

}
