package com.demo.advertising.general_management.services.models;

import com.demo.advertising.general_management.data.entities.CardEntity;
import com.demo.advertising.general_management.data.entities.PayPalEntity;

import java.util.List;

public class Customer {

    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<CardEntity> cardDetails;
    private List<PayPalEntity> paypalDetails;
    private String subscribe;

    public Customer(){

    }

    public Customer(String customerId, String name, String email, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String customerId, String name, String email, String phoneNumber, List<CardEntity> cardDetails,
                    List<PayPalEntity> paypalDetails, String subscribe) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cardDetails = cardDetails;
        this.paypalDetails = paypalDetails;
        this.subscribe = subscribe;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<CardEntity> getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(List<CardEntity> cardDetails) {
        this.cardDetails = cardDetails;
    }

    public List<PayPalEntity> getPaypalDetails() {
        return paypalDetails;
    }

    public void setPaypalDetails(List<PayPalEntity> paypalDetails) {
        this.paypalDetails = paypalDetails;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }
}
