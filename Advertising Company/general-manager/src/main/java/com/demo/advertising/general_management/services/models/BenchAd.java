package com.demo.advertising.general_management.services.models;

public class BenchAd extends AdSpace {
    private String location;       //town/park where ad space is
    private String position;       //back or seat of bench

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
