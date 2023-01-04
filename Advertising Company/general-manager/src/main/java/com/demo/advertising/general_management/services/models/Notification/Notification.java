package com.demo.advertising.general_management.services.models.Notification;

import com.demo.advertising.general_management.services.models.Customer;

public class Notification implements INotification {

    private final String email;

    public Notification(Customer customer){
        this.email = customer.getEmail();
    }

    @Override
    public String sendMessage(String message){
        return "Sending " + message + " by Email to " + email;
    }
    @Override
    public String getContact(){
        return email;
    }
}
