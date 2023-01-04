package com.demo.advertising.general_management.controllers.requests;

public class CreateBusAdRequest extends CreateAdSpaceRequest {
    private String busRoute;       //bus route
    private String position;       //side or back of bus

    public CreateBusAdRequest(String popularity, String size, String price, String minWeeks, String maxWeeks, String busRoute, String position) {
        super(popularity, size, price, minWeeks, maxWeeks);
        this.busRoute = busRoute;
        this.position = position;
    }

    public CreateBusAdRequest(){};

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
