package com.demo.advertising.general_management.services.models.Notification;

import java.util.List;

public class BaseNotificationDecorator implements INotification{

    private final INotification wrapped;

    BaseNotificationDecorator(INotification wrapped){
        this.wrapped = wrapped;
    }
    @Override
    public List<String> sendMessage(List<String> myList, String message){
        wrapped.sendMessage(myList, message);
        return myList;
    }
    @Override
    public String getContact(){
        return wrapped.getContact();
    }

}
