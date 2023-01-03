package com.demo.advertising.general_management.controllers.requests;

public class CreateBusAdRequest extends CreateAdSpaceRequest {
    private String BusRoute;       //bus route
    private String Position;       //side or back of bus

    CreateBusAdRequest(String BusRoute, String Position){
        this.BusRoute = BusRoute;
        this.Position = Position;
    }
    CreateBusAdRequest(){};

    public String getBusRoute() {
        return BusRoute;
    }

    public void setBusRoute(String BusRoute) {
        this.BusRoute = BusRoute;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }
}
