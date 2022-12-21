package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.controllers.requests.AdSpace;

import java.util.List;

public class GetBookingResponse {

    String customerId;
    String bookingId;
    List<AdSpace> bookingItems;

    public GetBookingResponse(String customerId, String bookingId, List<AdSpace> bookingItems) {
        this.customerId = customerId;
        this.bookingId = bookingId;
        this.bookingItems = bookingItems;
    }

    public GetBookingResponse(String customerId, List<AdSpace> bookingItems) {
        this.customerId = customerId;
        this.bookingItems = bookingItems;
    }

    public GetBookingResponse() {
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

    public List<AdSpace> getBookingItems() {
        return bookingItems;
    }

    public void setBookingItems(List<AdSpace> bookingItems) {
        this.bookingItems = bookingItems;
    }
}
