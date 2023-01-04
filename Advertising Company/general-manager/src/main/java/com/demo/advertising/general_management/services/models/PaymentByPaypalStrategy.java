package com.demo.advertising.general_management.services.models;

public class PaymentByPaypalStrategy implements PaymentStrategy {

    @Override
    public void selectPaymentMethod(){
        throw new RuntimeException("Selected Paypal payment method!");
    }
}
