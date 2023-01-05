package com.demo.advertising.general_management;

import com.demo.advertising.general_management.data.entities.CardEntity;
import com.demo.advertising.general_management.data.entities.CustomerEntity;
import com.demo.advertising.general_management.data.entities.PayPalEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomerEntityTests {
    static CustomerEntity customerToGet;
    static CustomerEntity customerToSet;

    @BeforeAll
    public static void setup(){
        customerToGet = new CustomerEntity("1", "Name1", "email1@gmail.com",
                "phone1", new CardEntity("string", "string", "string"),
                new PayPalEntity("user1", "pass1"), "no");

        customerToSet = new CustomerEntity();
    }

    // customer id getters and setters

    @Test
    public void getCustomerEntityIdTest(){
        String id = customerToGet.getCustomerId();
        Assertions.assertEquals("1", id);
    }

    @Test
    public void setCustomerEntityIdTest(){
        customerToSet.setCustomerId("2");
        Assertions.assertEquals("2",  customerToSet.getCustomerId());
    }

    // customer name getters and setters

    @Test
    public void getCustomerEntityNameTest(){
        String name = customerToGet.getName();
        Assertions.assertEquals("Name1", name);
    }

    @Test
    public void setCustomerEntityNameTest(){
        customerToSet.setName("Name2");
        Assertions.assertEquals("Name2",  customerToSet.getName());
    }

    // customer email getters and setters

    @Test
    public void getCustomerEntityEmailTest(){
        String email = customerToGet.getEmail();
        Assertions.assertEquals("email1@gmail.com", email);
    }

    @Test
    public void setCustomerEntityEmailTest(){
        customerToSet.setEmail("email2@gmail.com");
        Assertions.assertEquals("email2@gmail.com",  customerToSet.getEmail());
    }

    // customer phone number getters and setters

    @Test
    public void getCustomerEntityPhoneNumberTest(){
        String number = customerToGet.getPhoneNumber();
        Assertions.assertEquals("phone1", number);
    }

    @Test
    public void setCustomerEntityPhoneNumberTest(){
        customerToSet.setPhoneNumber("79213459");
        Assertions.assertEquals("79213459",  customerToSet.getPhoneNumber());
    }

    // customer card details getters and setters

    @Test
    public void getCustomerEntityCardTest(){
        CardEntity card = customerToGet.getCardDetails();
        Assertions.assertEquals("string", card.getCardNumber());
        Assertions.assertEquals("string", card.getExpiryDate());
        Assertions.assertEquals("string", card.getCvv());
    }

    @Test
    public void setCustomerEntityCardDetailsTest(){
        CardEntity cardDetails = new CardEntity("string","string","string");
        customerToSet.setCardDetails(cardDetails);
        Assertions.assertEquals(cardDetails, customerToSet.getCardDetails());
    }

    // customer paypal details getters and setters

    @Test
    public void getCustomerEntityPayPalTest(){
        PayPalEntity paypal = customerToGet.getPaypalDetails();
        Assertions.assertEquals("user1", paypal.getUsername());
        Assertions.assertEquals("pass1", paypal.getPassword());
    }

    @Test
    public void setCustomerEntityPaypalDetailsTest(){
        PayPalEntity paypalDetails = new PayPalEntity("user2","pass2");
        customerToSet.setPaypalDetails(paypalDetails);
        Assertions.assertEquals(paypalDetails, customerToSet.getPaypalDetails());
    }

    // customer subscribe getters and setters

    @Test
    public void getCustomerEntitySubscribeTest(){
        String subscribe = customerToGet.getSubscribe();
        Assertions.assertEquals("no", subscribe);
    }

    @Test
    public void setCustomerEntitySubscribeTest(){
        customerToSet.setSubscribe("yes");
        Assertions.assertEquals("yes", customerToSet.getSubscribe());
    }
}
