package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

public class CreateAdSpaceRequest {
    private AdSpace adSpace;
    private String Location;    //town/park where ad space is
    private int BusRoute;       //bus route


    public CreateAdSpaceRequest(AdSpace adSpace, String Location, int BusRoute) {
        this.adSpace = adSpace;
        this.Location = Location;
        this.BusRoute = BusRoute;
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

    public int getBusRoute() {
        return BusRoute;
    }

    public void setBusRoute(int busRoute) {
        BusRoute = busRoute;
    }
}
