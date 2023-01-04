package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.services.models.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentStrategy paymentStrategy;

    public void processPaymentMethod(){
        paymentStrategy.selectPaymentMethod();
    }

    public void setStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

}
