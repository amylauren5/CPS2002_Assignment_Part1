package com.demo.advertising.general_management.data.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CustomerEntity {

    @Id
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;

    @ElementCollection
    @CollectionTable(name="CARD_DETAILS", joinColumns=@JoinColumn(name="CUSTOMER_ID"))
    private List<CardEntity> cardDetails; // cardNumber, expiryDate, cvv

    @ElementCollection
    @CollectionTable(name="PAYPAL_DETAILS", joinColumns=@JoinColumn(name="CUSTOMER_ID"))
    private List<PayPalEntity> paypalDetails; // username and password

    private String subscribe; // subscribe to mailing list

    public CustomerEntity(){
    }

    public CustomerEntity(String customerId, String name, String email, String phoneNumber,
                          List<CardEntity> cardDetails, List<PayPalEntity> paypalDetails, String subscribe) {
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
