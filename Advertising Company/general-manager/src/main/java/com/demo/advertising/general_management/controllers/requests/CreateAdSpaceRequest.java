package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

public class CreateAdSpaceRequest {
    private String Location;    //town/park where ad space is


    public CreateAdSpaceRequest(String Location, int BusRoute) {
        this.Location = Location;
    }

    public CreateAdSpaceRequest() {
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

}
