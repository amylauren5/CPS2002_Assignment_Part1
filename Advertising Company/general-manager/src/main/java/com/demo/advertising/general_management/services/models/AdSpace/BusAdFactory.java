package com.demo.advertising.general_management.services.models.AdSpace;

public class BusAdFactory extends AdSpaceFactory{
    @Override
    public AdSpace createAdSpace(){
        return new BusAd();
    }
}
