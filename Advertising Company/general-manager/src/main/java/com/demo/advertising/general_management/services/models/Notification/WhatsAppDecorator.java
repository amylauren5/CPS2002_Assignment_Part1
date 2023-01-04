package com.demo.advertising.general_management.services.models.Notification;

import com.demo.advertising.general_management.services.models.Customer;

public class WhatsAppDecorator extends BaseNotificationDecorator {

    private final String phoneNumber;

    public WhatsAppDecorator(Customer customer, INotification wrapped){
        super(wrapped);
        phoneNumber = customer.getPhoneNumber();
    }

    @Override
    public String sendMessage(String message){
        super.sendMessage(message);
         return "Sending " + message + " by Whatsapp on " + phoneNumber;
    }
}
