package com.demo.advertising.general_management.data.entities;

import javax.persistence.*;

@Entity
@Table
public class AdSpaceEntity {

    @Id
    private String spaceId;
    private String popularity;     //people viewing space per day
    private String type;        //billboard, buses, benches
    private String length;           //size of advertising space
    private String width;
    private String price;          //cost to rent space per week
    private String minWeeks;
    private String maxWeeks;
    private String busRoute;       //bus route
    private String location;
    private String durationInterval;

    public AdSpaceEntity(String spaceId, String popularity, String type, String length, String width, String price, String minWeeks, String maxWeeks, String busRoute, String location, String durationInterval) {
        this.spaceId = spaceId;
        this.popularity = popularity;
        this.type = type;
        this.length = length;
        this.width = width;
        this.price = price;
        this.minWeeks = minWeeks;
        this.maxWeeks = maxWeeks;
        this.busRoute = busRoute;
        this.durationInterval = durationInterval;
        this.location = location;
    }

    public AdSpaceEntity(){};

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMinWeeks() {
        return minWeeks;
    }

    public void setMinWeeks(String minWeeks) {
        this.minWeeks = minWeeks;
    }

    public String getMaxWeeks() {
        return maxWeeks;
    }

    public void setMaxWeeks(String maxWeeks) {
        this.maxWeeks = maxWeeks;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDurationInterval() {
        return durationInterval;
    }

    public void setDurationInterval(String durationInterval) {
        this.durationInterval = durationInterval;
    }
}
