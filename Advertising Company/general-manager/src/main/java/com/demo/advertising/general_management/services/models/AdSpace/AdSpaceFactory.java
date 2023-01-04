package com.demo.advertising.general_management.services.models.AdSpace;

public class AdSpaceFactory {

    public AdSpace createAdSpace(String type){
        AdSpace newAdSpace = null;
        if("bus".equals(type)){
            newAdSpace = new BusAd();
        }else if("billboard".equals(type)){
            newAdSpace = new BillboardAd();
        }else if("bench".equals(type)){
            newAdSpace = new BenchAd();
        }
        return newAdSpace;
    }
}
