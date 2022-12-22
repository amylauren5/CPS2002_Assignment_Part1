package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.controllers.requests.AdSpace;
import com.demo.advertising.general_management.services.models.Adspace;

import java.util.List;

public class GetAdSpaceResponse {

    private Adspace adspace;

    public GetAdSpaceResponse(Adspace adspace) {
        this.adspace = adspace;
    }

    public GetAdSpaceResponse() {
    }

    public Adspace getAdspace() {
        return adspace;
    }
}
