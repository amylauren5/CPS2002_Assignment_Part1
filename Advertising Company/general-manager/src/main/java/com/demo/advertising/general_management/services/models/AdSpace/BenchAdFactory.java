package com.demo.advertising.general_management.services.models.AdSpace;

public class BenchAdFactory extends AdSpaceFactory{
    @Override
    public AdSpace createAdSpace(){
        return new BenchAd();
    }
}
