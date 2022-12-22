package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

public class CreateAdSpaceRequest {
    private List<AdSpace> adSpaces;

    public CreateAdSpaceRequest(List<AdSpace> adSpaces) {
        this.adSpaces = adSpaces;
    }

    public CreateAdSpaceRequest() {
    }

    public List<AdSpace> getBookingItems() {
        return adSpaces;
    }

    public void setBookingItems(List<AdSpace> bookingItems) {
        this.adSpaces = bookingItems;
    }

}
