package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

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
