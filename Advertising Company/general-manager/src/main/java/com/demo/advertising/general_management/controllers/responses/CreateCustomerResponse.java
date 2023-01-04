package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.services.models.Customer;

import java.util.List;

public class CreateCustomerResponse {
    private List<String> notificationMessage;
    private String paymentMessage;

    public CreateCustomerResponse(List<String> notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public CreateCustomerResponse(List<String> notificationMessage, String paymentMessage) {
        this.notificationMessage = notificationMessage;
        this.paymentMessage = paymentMessage;
    }

    public List<String> getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(List<String> notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public String getPaymentMessage() {
        return paymentMessage;
    }

    public void setPaymentMessage(String paymentMessage) {
        this.paymentMessage = paymentMessage;
    }
}
