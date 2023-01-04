package com.demo.advertising.general_management.services.models.Notification;

import com.demo.advertising.general_management.services.models.Customer;

import java.util.List;

public class SMSDecorator extends BaseNotificationDecorator {

    private final String phoneNumber;

    public SMSDecorator(Customer customer, INotification wrapped){
        super(wrapped);
        phoneNumber = customer.getPhoneNumber();
    }

    @Override
    public List<String> sendMessage(List<String> myList, String message){
        super.sendMessage(myList, message);
        myList.add("Sending " + message + " by SMS on " + phoneNumber);
        return myList;
    }
}
