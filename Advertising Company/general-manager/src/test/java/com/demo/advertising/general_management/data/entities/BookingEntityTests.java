package com.demo.advertising.general_management.data.entities;

import com.demo.advertising.general_management.data.entities.BookingEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookingEntityTests {


    static BookingEntity bookingToGet;
    static BookingEntity bookingToSet;

    @BeforeAll
    public static void setup(){
        bookingToGet = new BookingEntity("spaceId","customerId","bookingId","date", "weeks");
        bookingToSet = new BookingEntity();
    }

    // booking entity space id getters and setters

    @Test
    public void getBookingEntitySpaceIdTest(){
        String spaceId = bookingToGet.getSpaceId();
        Assertions.assertEquals("spaceId", spaceId);
    }

    @Test
    public void setBookingEntitySpaceIdTest(){
        bookingToSet.setSpaceId("spaceId");
        Assertions.assertEquals("spaceId",  bookingToSet.getSpaceId());
    }

    // booking entity customer id getters and setters

    @Test
    public void getBookingEntityCustomerIdTest(){
        String customerId = bookingToGet.getCustomerId();
        Assertions.assertEquals("customerId", customerId);
    }

    @Test
    public void setBookingEntityCustomerIdTest(){
        bookingToSet.setCustomerId("customerId");
        Assertions.assertEquals("customerId",  bookingToSet.getCustomerId());
    }

    // booking entity id getters and setters

    @Test
    public void getBookingEntityIdTest(){
        String bookingId = bookingToGet.getBookingId();
        Assertions.assertEquals("bookingId", bookingId);
    }

    @Test
    public void setBookingEntityIdTest(){
        bookingToSet.setBookingId("bookingId");
        Assertions.assertEquals("bookingId",  bookingToSet.getBookingId());
    }

    // booking entity starting date getters and setters

    @Test
    public void getBookingEntityStartingDateTest(){
        String date = bookingToGet.getStartingDate();
        Assertions.assertEquals("date", date);
    }

    @Test
    public void setBookingEntityStartingDateTest(){
        bookingToSet.setStartingDate("date2");
        Assertions.assertEquals("date2",  bookingToSet.getStartingDate());
    }


    // booking entity no of weeks getters and setters

    @Test
    public void getBookingEntityNoOfWeeksTest(){
        String weeks = bookingToGet.getNoOfWeeks();
        Assertions.assertEquals("weeks", weeks);
    }

    @Test
    public void setBookingEntityNoOfWeeksTest(){
        bookingToSet.setNoOfWeeks("weeks2");
        Assertions.assertEquals("weeks2",  bookingToSet.getNoOfWeeks());
    }
}
