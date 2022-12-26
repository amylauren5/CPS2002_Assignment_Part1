package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

public class CreateAdSpaceRequest {
    private AdSpace adSpace;
    private String Location;    //town/park where ad space is


    public CreateAdSpaceRequest(AdSpace adSpace, String Location) {
        this.adSpace = adSpace;
        this.Location = Location;
    }

    public CreateAdSpaceRequest() {
    }

    public AdSpace getAdSpace() {
        return adSpace;
    }

    public void setAdSpace(AdSpace adSpace) {
        this.adSpace = adSpace;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
