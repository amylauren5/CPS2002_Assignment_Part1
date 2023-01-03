package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.services.models.PaymentByCard;
import com.demo.advertising.general_management.services.models.PaymentByWebsite;
import com.demo.advertising.general_management.services.models.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private int cost;
    private boolean delivery;

    private PaymentStrategy paymentStrategy;

    public void processOrder(){
        paymentStrategy.selectPaymentMethod();
        paymentStrategy.pay();
    }

    public void setStrategy(PaymentByCard paymentByCard) {
        paymentStrategy.selectPaymentMethod();
    }

    public void setStrategy(PaymentByWebsite paymentByWebsite) {
        paymentStrategy.selectPaymentMethod();
    }
}
