package com.demo.advertising.general_management.controllers.responses;
import com.demo.advertising.general_management.services.models.Adspace;

public class GetAdSpaceResponse {

    private String SpaceId;
    private int Popularity;     //people viewing space per day
    private String Type;        //billboard, buses, benches
    private int Size;           //size of advertising space
    private int Price;          //cost to rent space per week
    private String Location;    //town/park where ad space is
    private int BusRoute;       //bus route

    public GetAdSpaceResponse(String SpaceId, int Popularity, String Type, int Size, int Price, String Location, int BusRoute) {
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

    public int getPopularity() {
        return Popularity;
    }

    public void setPopularity(int popularity) {
        Popularity = popularity;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
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
