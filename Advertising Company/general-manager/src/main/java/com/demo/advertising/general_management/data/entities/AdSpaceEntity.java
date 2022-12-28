package com.demo.advertising.general_management.data.entities;

import javax.persistence.*;

@Entity
@Table
public class AdSpaceEntity {

    @Id
    private String SpaceId;
    private String Popularity;     //people viewing space per day
    private String Type;        //billboard, buses, benches
    private String Size;           //size of advertising space
    private String Price;          //cost to rent space per week
    private String Location;    //town/park where ad space is
    private String BusRoute;       //bus route
    private String MinWeeks;
    private String MaxWeeks;

    public String getSpaceId() {
        return SpaceId;
    }

    public void setSpaceId(String SpaceId) {this.SpaceId = SpaceId;}

    public String getPopularity() {
        return Popularity;
    }

    public void setPopularity(String Popularity) {
        this.Popularity = Popularity;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getBusRoute() {
        return BusRoute;
    }

    public void setBusRoute(String BusRoute) {
        this.BusRoute = BusRoute;
    }

    public String getMinWeeks() {
        return MinWeeks;
    }

    public void setMinWeeks(String minWeeks) {
        MinWeeks = minWeeks;
    }

    public String getMaxWeeks() {
        return MaxWeeks;
    }

    public void setMaxWeeks(String maxWeeks) {
        MaxWeeks = maxWeeks;
    }
}
