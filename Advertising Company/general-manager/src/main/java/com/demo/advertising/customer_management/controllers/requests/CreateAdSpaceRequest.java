package com.demo.advertising.customer_management.controllers.requests;

public class CreateAdSpaceRequest {

    private AdSpace adSpace;

    public CreateAdSpaceRequest(AdSpace adSpace) {
        this.adSpace = adSpace;
    }

    public CreateAdSpaceRequest() {
    }

    public AdSpace getAdSpace() {
        return adSpace;
    }

    public void setAdSpace(AdSpace adSpace) {
        this.adSpace = adSpace;
    }

}
