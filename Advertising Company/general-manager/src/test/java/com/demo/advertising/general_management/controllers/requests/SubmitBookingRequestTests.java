package com.demo.advertising.general_management.controllers.requests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SubmitBookingRequestTests {

    static SubmitBookingRequest bookingToGet;
    static SubmitBookingRequest bookingToSet;

    @BeforeAll
    public static void setup(){
        bookingToGet = new SubmitBookingRequest("spaceId", "date", "3");
        bookingToSet = new SubmitBookingRequest();
    }

    // booking request space id getters and setters

    @Test
    public void getSubmitBookingRequestSpaceIdTest(){
        String spaceId = bookingToGet.getSpaceId();
        Assertions.assertEquals("spaceId", spaceId);
    }

    @Test
    public void setSubmitBookingRequestSpaceIdTest(){
        bookingToSet.setSpaceId("spaceId2");
        Assertions.assertEquals("spaceId2",  bookingToSet.getSpaceId());
    }

    // booking request space id getters and setters

    @Test
    public void getSubmitBookingRequestStartingDateTest(){
        String date = bookingToGet.getStartingDate();
        Assertions.assertEquals("date", date);
    }

    @Test
    public void setSubmitBookingRequestStartingDateTest(){
        bookingToSet.setStartingDate("date2");
        Assertions.assertEquals("date2",  bookingToSet.getStartingDate());
    }

    // booking request space id getters and setters

    @Test
    public void getSubmitBookingRequestNoOfWeeksTest(){
        String weeks = bookingToGet.getNoOfWeeks();
        Assertions.assertEquals("3", weeks);
    }

    @Test
    public void setSubmitBookingRequestNoOfWeeksTest(){
        bookingToSet.setNoOfWeeks("weeks2");
        Assertions.assertEquals("weeks2",  bookingToSet.getNoOfWeeks());
    }
}
