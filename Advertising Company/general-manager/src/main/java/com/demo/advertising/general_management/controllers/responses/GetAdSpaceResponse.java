package com.demo.advertising.general_management.controllers.responses;
import com.demo.advertising.general_management.controllers.requests.AdSpace;


public class GetAdSpaceResponse {

    private String SpaceId;
    private String Popularity;     //people viewing space per day
    private String Type;        //billboard, buses, benches
    private String Size;           //size of advertising space
    private String Price;          //cost to rent space per week
    private String Location;    //town/park where ad space is
    private String BusRoute;       //bus route

    public GetAdSpaceResponse(String SpaceId, String Popularity, String Type, String Size, String Price, String Location, String BusRoute) {
        this.SpaceId = SpaceId;
        this.Popularity = Popularity;
        this.Type = Type;
        this.Size = Size;
        this.Price = Price;
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

    public String getPopularity() {
        return Popularity;
    }

    public void setPopularity(String popularity) {
        Popularity = popularity;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getBusRoute() {
        return BusRoute;
    }

    public void setBusRoute(String busRoute) {
        BusRoute = busRoute;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
