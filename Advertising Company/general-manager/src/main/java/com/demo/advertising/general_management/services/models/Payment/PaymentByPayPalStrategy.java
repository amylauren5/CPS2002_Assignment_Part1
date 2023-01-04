package com.demo.advertising.general_management.services.models.Payment;

public class PaymentByPayPalStrategy implements PaymentStrategy {

    @Override
    public String selectPaymentMethod(){
        return "You will pay by PayPal!";
    }
}