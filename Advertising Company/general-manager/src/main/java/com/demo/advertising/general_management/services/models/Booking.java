package com.demo.advertising.general_management.services.models;

import java.time.LocalDate;
import java.util.List;

public class Booking {

    private String SpaceId;
    private String customerId;
    private String bookingId;
    private String startingDate;
    private String noOfWeeks;

    public Booking() {

    }

    public Booking(String spaceId, String customerId, String bookingId, String startingDate, String noOfWeeks) {
        SpaceId = spaceId;
        this.customerId = customerId;
        this.bookingId = bookingId;
        this.startingDate = startingDate;
        this.noOfWeeks = noOfWeeks;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getNoOfWeeks() {
        return noOfWeeks;
    }

    public void setNoOfWeeks(String noOfWeeks) {
        this.noOfWeeks = noOfWeeks;
    }

    public String getSpaceId() {
        return SpaceId;
    }

    public void setSpaceId(String spaceId) {
        SpaceId = spaceId;
    }

}
