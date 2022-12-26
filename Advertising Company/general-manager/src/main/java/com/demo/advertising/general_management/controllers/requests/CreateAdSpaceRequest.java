package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

public class CreateAdSpaceRequest {
    private int Popularity;     //people viewing space per day
    private String Type;        //billboard, buses, benches
    private int Size;           //size of advertising space
    private int Price;          //cost to rent space per week
    private String Location;    //town/park where ad space is
    private int BusRoute;       //bus route

    public CreateAdSpaceRequest(int Popularity, String Type, int Size, int Price, String Location, int BusRoute) {
        this.Popularity = Popularity;
        this.Type = Type;
        this.Size = Size;
        this.Price = Price;
        this.Location = Location;
        this.BusRoute = BusRoute;
    }

    public CreateAdSpaceRequest() {
    }

    public int getPopularity() {
        return Popularity;
    }

    public void setPopularity(int Popularity) {
        this.Popularity = Popularity;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getBusRoute() {
        return BusRoute;
    }

    public void setBusRoute(int BusRoute) {
        this.BusRoute = BusRoute;
    }

}
