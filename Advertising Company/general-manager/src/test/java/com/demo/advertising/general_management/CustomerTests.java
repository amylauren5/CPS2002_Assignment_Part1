package com.demo.advertising.general_management;

import com.demo.advertising.general_management.data.entities.CardEntity;
import com.demo.advertising.general_management.data.entities.PayPalEntity;
import com.demo.advertising.general_management.services.models.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomerTests {

    static Customer customerToGet;
    static Customer customerToSet;

    @BeforeAll
    public static void setup(){
        customerToGet = new Customer("1", "Name1", "email1@gmail.com",
                "phone1", new CardEntity("string", "string", "string"),
                new PayPalEntity("user1", "pass1"), "no");

        customerToSet = new Customer();
    }

    // customer id getters and setters

    @Test
    public void getIdTest(){
        String id = customerToGet.getCustomerId();
        Assertions.assertEquals("1", id);
    }

    @Test
    public void setIdTest(){
        customerToSet.setCustomerId("2");
        Assertions.assertEquals("2",  customerToSet.getCustomerId());
    }

    // customer name getters and setters

    @Test
    public void getNameTest(){
        String name = customerToGet.getName();
        Assertions.assertEquals("Name1", name);
    }

    @Test
    public void setNameTest(){
        customerToSet.setName("Name2");
        Assertions.assertEquals("Name2",  customerToSet.getName());
    }

    // customer email getters and setters

    @Test
    public void getEmailTest(){
        String email = customerToGet.getEmail();
        Assertions.assertEquals("email1@gmail.com", email);
    }

    @Test
    public void setEmailTest(){
        customerToSet.setEmail("email2@gmail.com");
        Assertions.assertEquals("email2@gmail.com",  customerToSet.getEmail());
    }

    // customer phone number getters and setters

    @Test
    public void getPhoneNumberTest(){
        String number = customerToGet.getPhoneNumber();
        Assertions.assertEquals("phone1", number);
    }

    @Test
    public void setPhoneNumberTest(){
        customerToSet.setPhoneNumber("79213459");
        Assertions.assertEquals("79213459",  customerToSet.getPhoneNumber());
    }

    // customer card details getters and setters

    @Test
    public void getCardTest(){
        CardEntity card = customerToGet.getCardDetails();
        Assertions.assertEquals("string", card.getCardNumber());
        Assertions.assertEquals("string", card.getExpiryDate());
        Assertions.assertEquals("string", card.getCvv());
    }

    @Test
    public void setCardDetailsTest(){
        CardEntity cardDetails = new CardEntity("string","string","string");
        customerToSet.setCardDetails(cardDetails);
        Assertions.assertEquals(cardDetails, customerToSet.getCardDetails());
    }

    // customer paypal details getters and setters

    @Test
    public void getPayPalTest(){
        PayPalEntity paypal = customerToGet.getPaypalDetails();
        Assertions.assertEquals("user1", paypal.getUsername());
        Assertions.assertEquals("pass1", paypal.getPassword());
    }

    @Test
    public void setPaypalDetailsTest(){
        PayPalEntity paypalDetails = new PayPalEntity("user2","pass2");
        customerToSet.setPaypalDetails(paypalDetails);
        Assertions.assertEquals(paypalDetails, customerToSet.getPaypalDetails());
    }

    // customer subscribe getters and setters

    @Test
    public void getSubscribeTest(){
        String subscribe = customerToGet.getSubscribe();
        Assertions.assertEquals("no", subscribe);
    }

    @Test
    public void setSubscribeTest(){
        customerToSet.setSubscribe("yes");
        Assertions.assertEquals("yes", customerToSet.getSubscribe());
    }
}
