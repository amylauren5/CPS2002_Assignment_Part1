package com.demo.advertising.general_management.controllers.requests;

import java.util.List;

public class CreateAdSpaceRequest {
    private String Popularity;     //people viewing space per day
    private String Size;           //size of advertising space
    private String Price;          //cost to rent space per week
    private String MinWeeks;
    private String MaxWeeks;

    public CreateAdSpaceRequest(String Popularity, String Size, String Price, String MinWeeks, String MaxWeeks) {
        this.Popularity = Popularity;
        this.Size = Size;
        this.Price = Price;
        this.MinWeeks = MinWeeks;
        this.MaxWeeks = MaxWeeks;
    }

    public CreateAdSpaceRequest() {
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

