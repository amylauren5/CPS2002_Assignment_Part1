package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

public class SubmitBookingRequest {
    private List<AdSpace> bookingItems;

    public SubmitBookingRequest(List<AdSpace> bookingItems) {
        this.bookingItems = bookingItems;
    }

    public SubmitBookingRequest() {
    }

    public List<AdSpace> getBookingItems() {
        return bookingItems;
    }

    public void setBookingItems(List<AdSpace> bookingItems) {
        this.bookingItems = bookingItems;
    }

}
