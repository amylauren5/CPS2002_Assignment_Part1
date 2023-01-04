package com.demo.advertising.general_management.controllers.requests;

public class CreateBillboardAdRequest extends CreateAdSpaceRequest {

    private String location;    //town/park where ad space is
    private String index;       //index of ad

    public CreateBillboardAdRequest(String popularity, String size, String price, String minWeeks, String maxWeeks, String location, String index) {
        super(popularity, size, price, minWeeks, maxWeeks);
        this.location = location;
        this.index = index;
    }

    public CreateBillboardAdRequest(){}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
