package com.demo.advertising.general_management.services.models.Notification;

public class BaseNotificationDecorator implements INotification{

    private final INotification wrapped;

    BaseNotificationDecorator(INotification wrapped){
        this.wrapped = wrapped;
    }
    @Override
    public String sendMessage(String message){
        wrapped.sendMessage(message);
        return message;
    }
    @Override
    public String getContact(){
        return wrapped.getContact();
    }

}
