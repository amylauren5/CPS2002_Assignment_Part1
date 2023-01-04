package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

public class CreateAdSpaceRequest {
    private String popularity;     //people viewing space per day
    private String size;           //size of advertising space
    private String price;          //cost to rent space per week
    private String minWeeks;
    private String maxWeeks;
    private String type;

    public CreateAdSpaceRequest(String popularity, String size, String price, String minWeeks, String maxWeeks, String type) {
        this.popularity = popularity;
        this.size = size;
        this.price = price;
        this.minWeeks = minWeeks;
        this.maxWeeks = maxWeeks;
        this.type = type;
    }

    public CreateAdSpaceRequest(){}

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

