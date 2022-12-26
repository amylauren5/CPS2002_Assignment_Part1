package com.demo.advertising.general_management.controllers.responses;
import com.demo.advertising.general_management.controllers.requests.AdSpace;


public class GetAdSpaceResponse {

    private AdSpace adspace;
    private String SpaceId;
    private String Location;    //town/park where ad space is
    private int BusRoute;       //bus route


    public GetAdSpaceResponse(AdSpace adspace, String SpaceId, String Location, int BusRoute) {
        this.adspace = adspace;
        this.SpaceId = SpaceId;
        this.Location = Location;
        this.BusRoute = BusRoute;
    }

    public GetAdSpaceResponse() {
    }

    public AdSpace getAdspace() {
        return adspace;
    }

    public void setAdspace(AdSpace adspace) {
        this.adspace = adspace;
    }

    public String getSpaceId() {
        return SpaceId;
    }

    public void setSpaceId(String spaceId) {
        SpaceId = spaceId;
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
