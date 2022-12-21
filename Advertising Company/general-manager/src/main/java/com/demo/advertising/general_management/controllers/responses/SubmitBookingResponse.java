package com.demo.advertising.general_management.controllers.responses;

public class SubmitBookingResponse {

    private String bookingId;

    public SubmitBookingResponse(String bookingId) {
        this.bookingId = bookingId;
    }

    public SubmitBookingResponse() {
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String orderId) {
        this.bookingId = bookingId;
    }
}
