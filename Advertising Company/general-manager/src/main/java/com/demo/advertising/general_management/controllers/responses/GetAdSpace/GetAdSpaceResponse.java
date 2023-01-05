package com.demo.advertising.general_management.controllers.responses.GetAdSpace;

public class GetAdSpaceResponse {
    private String spaceId;
    private String popularity;     //people viewing space per day
    private String type;        //billboard, buses, benches
    private String size;           //size of advertising space
    private String price;          //cost to rent space per week
    private String minWeeks;
    private String maxWeeks;
    private String index;

    public GetAdSpaceResponse(String spaceId, String popularity, String type, String size, String price, String minWeeks, String maxWeeks, String index) {
        this.spaceId = spaceId;
        this.popularity = popularity;
        this.type = type;
        this.size = size;
        this.price = price;
        this.minWeeks = minWeeks;
        this.maxWeeks = maxWeeks;
        this.index = index;
    }

    public GetAdSpaceResponse(){};

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


    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}

