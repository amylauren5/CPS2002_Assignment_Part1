package com.demo.advertising.general_management.controllers.requests;

public class CreateBillboardAdRequest extends CreateAdSpaceRequest {

    private String Location;    //town/park where ad space is
    private String Index;       //index of ad

    CreateBillboardAdRequest(String Location, String Index){
        this.Location = Location;
        this.Index = Index;
    }

    CreateBillboardAdRequest(){};

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getIndex() {
        return Index;
    }

    public void setIndex(String Index) {
        this.Index = Index;
    }
}
