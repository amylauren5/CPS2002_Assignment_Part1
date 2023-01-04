package com.demo.advertising.general_management.services.models;

public class PaymentByPayPalStrategy implements PaymentStrategy {

    @Override
    public void selectPaymentMethod(){
        throw new RuntimeException("Selected Paypal payment method!");
    }
}