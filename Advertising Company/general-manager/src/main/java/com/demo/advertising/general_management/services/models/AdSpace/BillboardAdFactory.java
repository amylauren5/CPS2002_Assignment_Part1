package com.demo.advertising.general_management.services.models.AdSpace;

public class BillboardAdFactory extends AdSpaceFactory{

    @Override
    public AdSpace createAdSpace(){
        return new BillboardAd();
    }
}
