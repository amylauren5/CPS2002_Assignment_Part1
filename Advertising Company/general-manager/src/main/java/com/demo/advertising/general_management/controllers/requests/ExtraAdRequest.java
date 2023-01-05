package com.demo.advertising.general_management.controllers.requests;

public class ExtraAdRequest {

    private String location;
    private String busRoute;

    public ExtraAdRequest(String location, String busRoute) {
        this.location = location;
        this.busRoute = busRoute;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
