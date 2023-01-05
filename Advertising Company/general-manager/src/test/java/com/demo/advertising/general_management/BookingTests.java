package com.demo.advertising.general_management;

import com.demo.advertising.general_management.services.models.Booking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookingTests {

    static Booking bookingToGet;
    static Booking bookingToSet;

    @BeforeAll
    public static void setup(){
        bookingToGet = new Booking("spaceId","customerId","bookingId","date", "weeks");
        bookingToSet = new Booking();
    }

    // booking space id getters and setters

    @Test
    public void getBookingSpaceIdTest(){
        String spaceId = bookingToGet.getSpaceId();
        Assertions.assertEquals("spaceId", spaceId);
    }

    @Test
    public void setBookingSpaceIdTest(){
        bookingToSet.setSpaceId("spaceId");
        Assertions.assertEquals("spaceId",  bookingToSet.getSpaceId());
    }

    // booking customer id getters and setters

    @Test
    public void getBookingCustomerIdTest(){
        String customerId = bookingToGet.getCustomerId();
        Assertions.assertEquals("customerId", customerId);
    }

    @Test
    public void setBookingCustomerIdTest(){
        bookingToSet.setCustomerId("customerId");
        Assertions.assertEquals("customerId",  bookingToSet.getCustomerId());
    }

    // booking id getters and setters

    @Test
    public void getBookingIdTest(){
        String bookingId = bookingToGet.getBookingId();
        Assertions.assertEquals("bookingId", bookingId);
    }

    @Test
    public void setBookingIdTest(){
        bookingToSet.setBookingId("bookingId");
        Assertions.assertEquals("bookingId",  bookingToSet.getBookingId());
    }

    // booking starting date getters and setters

    @Test
    public void getBookingStartingDateTest(){
        String date = bookingToGet.getStartingDate();
        Assertions.assertEquals("date", date);
    }

    @Test
    public void setBookingStartingDateTest(){
        bookingToSet.setStartingDate("date2");
        Assertions.assertEquals("date2",  bookingToSet.getStartingDate());
    }


    // booking no of weeks getters and setters

    @Test
    public void getBookingNoOfWeeksTest(){
        String weeks = bookingToGet.getNoOfWeeks();
        Assertions.assertEquals("weeks", weeks);
    }

    @Test
    public void setBookingNoOfWeeksTest(){
        bookingToSet.setNoOfWeeks("weeks2");
        Assertions.assertEquals("weeks2",  bookingToSet.getNoOfWeeks());
    }
}
