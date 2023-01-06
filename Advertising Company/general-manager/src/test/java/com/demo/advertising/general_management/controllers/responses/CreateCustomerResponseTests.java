package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.data.entities.CardEntity;
import com.demo.advertising.general_management.data.entities.PayPalEntity;
import com.demo.advertising.general_management.services.models.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateCustomerResponseTests {

    static CreateCustomerResponse customerToGet;
    static CreateCustomerResponse customerToSet;

    static List<String> messageList;

    @BeforeAll
    public static void setup(){

        customerToGet = new CreateCustomerResponse(
                new Customer("1", "Name1", "email1@gmail.com",
                        "phone1", new CardEntity("string", "string", "string"),
                        new PayPalEntity("user1", "pass1"), "no"),
                messageList, "payment1");

        messageList = new ArrayList<>();
        messageList.add("sample message");

        customerToSet = new CreateCustomerResponse();

    }

    @Test
    public void getNotificationMessageTest(){
        List<String> newMessageList = customerToGet.getNotificationMessage();
        Assertions.assertEquals(newMessageList, messageList);
    }

    @Test
    public void setNotificationMessageTest(){
        customerToSet.setNotificationMessage(messageList);
        Assertions.assertEquals(messageList,  customerToSet.getNotificationMessage());
    }

    @Test
    public void getPaymentMessageTest(){
        String payMessage = customerToGet.getPaymentMessage();
        Assertions.assertEquals("payment1", payMessage);
    }

    @Test
    public void setPaymentMessageTest(){
        customerToSet.setPaymentMessage("payment2");
        Assertions.assertEquals("payment2",  customerToSet.getPaymentMessage());
    }
}
