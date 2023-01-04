package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.services.models.Customer;

public class CreateCustomerResponse {
    private String notificationMessage;
    private String paymentMessage;

    public CreateCustomerResponse(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public CreateCustomerResponse(String notificationMessage, String paymentMessage) {
        this.notificationMessage = notificationMessage;
        this.paymentMessage = paymentMessage;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public String getPaymentMessage() {
        return paymentMessage;
    }

    public void setPaymentMessage(String paymentMessage) {
        this.paymentMessage = paymentMessage;
    }
}
