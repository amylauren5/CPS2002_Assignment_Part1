package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

public class CreateAdSpaceRequest {
    private String Location;    //town/park where ad space is
    private int BusRoute;       //bus route


    public CreateAdSpaceRequest(String Location, int BusRoute) {
        this.Location = Location;
        this.BusRoute = BusRoute;
    }

    public CreateAdSpaceRequest() {
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
