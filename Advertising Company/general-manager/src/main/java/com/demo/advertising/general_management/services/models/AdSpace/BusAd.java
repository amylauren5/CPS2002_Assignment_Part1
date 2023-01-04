package com.demo.advertising.general_management.services.models.AdSpace;

import com.demo.advertising.general_management.services.models.AdSpace.AdSpace;

public class BusAd extends AdSpace {
    private String busRoute;       //bus route

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }

}
