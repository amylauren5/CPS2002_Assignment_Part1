package com.demo.advertising.general_management.controllers.requests;

public class CreateBenchAdRequest extends CreateAdSpaceRequest {
    private String Location;       //town/park where ad space is
    private String Position;       //back or seat of bench
    CreateBenchAdRequest(String Location, String Position){
        this.Location = Location;
        this.Position = Position;
    }
    CreateBenchAdRequest(){};

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }
}
