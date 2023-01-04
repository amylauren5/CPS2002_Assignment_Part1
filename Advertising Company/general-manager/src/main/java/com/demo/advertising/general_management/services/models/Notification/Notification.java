package com.demo.advertising.general_management.services.models.Notification;

import com.demo.advertising.general_management.services.models.Customer;

import java.util.List;

public class Notification implements INotification {

    private final String email;

    public Notification(Customer customer){
        this.email = customer.getEmail();
    }

    @Override
    public List<String> sendMessage(List<String> myList, String message){

        myList.add("Sending " + message + " by Email to " + email);
        return myList;
    }
    @Override
    public String getContact(){
        return email;
    }
}
