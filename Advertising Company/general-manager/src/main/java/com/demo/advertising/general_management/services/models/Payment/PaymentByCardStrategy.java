package com.demo.advertising.general_management.services.models.Payment;

public class PaymentByCardStrategy implements PaymentStrategy {

    @Override
    public String selectPaymentMethod() {
        return "You will pay by card!";
    }

}
