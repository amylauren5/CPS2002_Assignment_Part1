package com.demo.advertising.general_management.services.models.AdSpace;

import com.demo.advertising.general_management.services.AdSpaceService;

public class BillboardAdFactory extends AdSpaceService {

    @Override
    public AdSpace createAdSpace(){
        return new BillboardAd();
    }
}
