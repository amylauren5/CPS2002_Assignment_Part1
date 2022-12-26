package com.demo.advertising.general_management.controllers.requests;

public class AdSpace {

    private AdSpace adSpace;


    public AdSpace(AdSpace adSpace) {
        this.adSpace = adSpace;
    }

    public AdSpace(){
    }

    public AdSpace getAdSpace() {
        return adSpace;
    }

    public void setAdSpace(AdSpace adSpace) {
        this.adSpace = adSpace;
    }

}

