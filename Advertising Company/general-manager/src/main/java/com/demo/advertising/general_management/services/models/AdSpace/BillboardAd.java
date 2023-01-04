package com.demo.advertising.general_management.services.models.AdSpace;

import com.demo.advertising.general_management.services.models.AdSpace.AdSpace;

public class BillboardAd extends AdSpace {
    private String location;    //town/park where ad space is
    private String index;       //index of ad

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
