package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

public class CreateAdSpaceRequest {
    private String Location;    //town/park where ad space is
    private String Type;        //billboard, buses, benches


    public CreateAdSpaceRequest(String Location, String Type) {
        this.Location = Location;
        this.Type = Type;
    }

    public CreateAdSpaceRequest() {
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
