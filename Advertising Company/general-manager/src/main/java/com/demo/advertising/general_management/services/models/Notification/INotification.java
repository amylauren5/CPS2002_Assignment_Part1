package com.demo.advertising.general_management.services.models.Notification;

import java.util.List;

public interface INotification {
    List<String> sendMessage(List<String> myList, String message);
    String getContact();
}
