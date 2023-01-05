package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.services.models.Customer;

import java.util.List;

public class CreateCustomerResponse {

    Customer customer;
    private List<String> notificationMessage;
    private String paymentMessage;

    public CreateCustomerResponse(){

    }

    public CreateCustomerResponse(Customer customer, List<String> notificationMessage, String paymentMessage) {
        this.customer = customer;
        this.notificationMessage = notificationMessage;
        this.paymentMessage = paymentMessage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
