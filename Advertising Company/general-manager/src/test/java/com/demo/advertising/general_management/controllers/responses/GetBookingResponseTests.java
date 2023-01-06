package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.services.models.AdSpace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetBookingResponseTests {


    static GetBookingResponse bookingToGet;
    static GetBookingResponse bookingToSet;

    static List<AdSpace> adSpaceList;

    @BeforeAll
    public static void setup(){
        adSpaceList = new ArrayList<>();
        bookingToGet = new GetBookingResponse("customerId","bookingId","spaceId","date", "weeks", "1000",adSpaceList);
        bookingToSet = new GetBookingResponse();
    }

    // booking customer id getters and setters

    @Test
    public void getBookingResponseCustomerIdTest(){
        String customerId = bookingToGet.getCustomerId();
        Assertions.assertEquals("customerId", customerId);
    }

    @Test
    public void setBookingResponseCustomerIdTest(){
        bookingToSet.setCustomerId("customerId");
        Assertions.assertEquals("customerId",  bookingToSet.getCustomerId());
    }

    // booking id getters and setters

    @Test
    public void getBookingResponseIdTest(){
        String bookingId = bookingToGet.getBookingId();
        Assertions.assertEquals("bookingId", bookingId);
    }

    @Test
    public void setBookingResponseIdTest(){
        bookingToSet.setBookingId("bookingId");
        Assertions.assertEquals("bookingId",  bookingToSet.getBookingId());
    }

    // booking space id getters and setters

    @Test
    public void getBookingResponseSpaceIdTest(){
        String spaceId = bookingToGet.getSpaceId();
        Assertions.assertEquals("spaceId", spaceId);
    }

    @Test
    public void setBookingResponseSpaceIdTest(){
        bookingToSet.setSpaceId("spaceId2");
        Assertions.assertEquals("spaceId2",  bookingToSet.getSpaceId());
    }

    // booking starting date getters and setters

    @Test
    public void getBookingResponseStartingDateTest(){
        String date = bookingToGet.getStartingDate();
        Assertions.assertEquals("date", date);
    }

    @Test
    public void setBookingResponseStartingDateTest(){
        bookingToSet.setStartingDate("date2");
        Assertions.assertEquals("date2",  bookingToSet.getStartingDate());
    }


    // booking no of weeks getters and setters

    @Test
    public void getBookingResponseNoOfWeeksTest(){
        String weeks = bookingToGet.getNoOfWeeks();
        Assertions.assertEquals("weeks", weeks);
    }

    @Test
    public void setBookingResponseNoOfWeeksTest(){
        bookingToSet.setNoOfWeeks("weeks2");
        Assertions.assertEquals("weeks2",  bookingToSet.getNoOfWeeks());
    }

    // booking price getters and setters

    @Test
    public void getBookingResponsePriceTest(){
        String price = bookingToGet.getPrice();
        Assertions.assertEquals("1000", price);
    }

    @Test
    public void setBookingResponsePriceTest(){
        bookingToSet.setPrice("1500");
        Assertions.assertEquals("1500",  bookingToSet.getPrice());
    }

    // booking ad space getters and setters

    @Test
    public void getBookingResponseAdspaceTest(){
        List<AdSpace> adSpace = bookingToGet.getAdspace();
        Assertions.assertEquals(adSpaceList, adSpace);
    }

    @Test
    public void setBookingResponseAdspaceTest(){
        bookingToSet.setAdspace(adSpaceList);
        Assertions.assertEquals(adSpaceList,  bookingToSet.getAdspace());
    }
}
