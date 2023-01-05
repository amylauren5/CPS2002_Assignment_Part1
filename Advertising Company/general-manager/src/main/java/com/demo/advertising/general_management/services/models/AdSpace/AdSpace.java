package com.demo.advertising.general_management.services.models.AdSpace;

public class AdSpace {
    private String spaceId;
    private String popularity;     //people viewing space per day
    private String type;        //billboard, buses, benches
    private String size;           //size of advertising space
    private String price;          //cost to rent space per week
    private String minWeeks;
    private String maxWeeks;
    private String index;

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

