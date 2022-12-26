package com.demo.advertising.general_management.controllers.responses;
import com.demo.advertising.general_management.controllers.requests.AdSpace;


public class GetAdSpaceResponse {

    private String SpaceId;
    private String Location;    //town/park where ad space is
    private int BusRoute;       //bus route


    public GetAdSpaceResponse(String SpaceId, String Location, int BusRoute) {

        this.SpaceId = SpaceId;
        this.Location = Location;
        this.BusRoute = BusRoute;
    }

    public GetAdSpaceResponse() {
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
