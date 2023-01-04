package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.services.models.PaymentByCardStrategy;
import com.demo.advertising.general_management.services.models.PaymentByPaypalStrategy;
import com.demo.advertising.general_management.services.models.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private int cost;
    private boolean delivery;

    private PaymentStrategy paymentStrategy;

    public void processOrder(){
        paymentStrategy.selectPaymentMethod();
    }

    public void setStrategy(PaymentByCardStrategy paymentByCard) {
        this.paymentStrategy = paymentByCard;
    }

    public void setStrategy(PaymentByPaypalStrategy paymentByPaypal) {
        this.paymentStrategy = paymentByPaypal;
    }

}
