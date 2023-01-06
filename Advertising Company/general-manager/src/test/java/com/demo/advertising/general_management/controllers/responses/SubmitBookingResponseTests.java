package com.demo.advertising.general_management.controllers.responses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SubmitBookingResponseTests {

    static SubmitBookingResponse bookingToGet;
    static SubmitBookingResponse bookingToSet;

    @BeforeAll
    public static void setup(){
        bookingToGet = new SubmitBookingResponse("bookingId");
        bookingToSet = new SubmitBookingResponse();
    }

    // booking id getters and setters

    @Test
    public void getSubmitBookingResponseIdTest(){
        String bookingId = bookingToGet.getBookingId();
        Assertions.assertEquals("bookingId", bookingId);
    }

    @Test
    public void setSubmitBookingResponseIdTest(){
        bookingToSet.setBookingId("bookingId");
        Assertions.assertEquals("bookingId",  bookingToSet.getBookingId());
    }
}
