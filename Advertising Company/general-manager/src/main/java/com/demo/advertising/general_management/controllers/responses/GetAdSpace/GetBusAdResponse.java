package com.demo.advertising.general_management.controllers.responses.GetAdSpace;

import com.demo.advertising.general_management.controllers.responses.GetAdSpace.GetAdSpaceResponse;

public class GetBusAdResponse extends GetAdSpaceResponse {

    private String busRoute;       //bus route

    public GetBusAdResponse(String spaceId, String popularity, String type, String size, String price, String minWeeks, String maxWeeks, String index, String busRoute) {
        super(spaceId, popularity, type, size, price, minWeeks, maxWeeks, index);
        this.busRoute = busRoute;
    }

    public GetBusAdResponse() {
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }
}
