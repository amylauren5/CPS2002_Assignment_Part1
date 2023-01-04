package com.demo.advertising.general_management.controllers.requests;

public class CreateBenchAdRequest extends CreateAdSpaceRequest {
    private String location;       //town/park where ad space is
    private String position;       //back or seat of bench

    public CreateBenchAdRequest(String popularity, String size, String price, String minWeeks, String maxWeeks, String location, String position) {
        super(popularity, size, price, minWeeks, maxWeeks);
        this.location = location;
        this.position = position;
    }

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
