package com.demo.advertising.general_management.services.models;

public class BusAd extends AdSpace {
    private String busRoute;       //bus route
    private String position;       //side or back of bus

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
