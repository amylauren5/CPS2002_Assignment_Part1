package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.services.models.Adspace;

public class CreateAdSpaceResponse {

    private String SpaceId;
    private Adspace adspace;

    public CreateAdSpaceResponse(String SpaceId, Adspace adspace) {
        this.SpaceId = SpaceId;
        this.adspace = adspace;
    }

    public CreateAdSpaceResponse() {
    }

    public String getAdSpaceId() {
        return SpaceId;
    }

    public void setAdSpaceId(String SpaceId) {
        this.SpaceId = SpaceId;
    }

    public Adspace getAdSpace() {
        return adspace;
    }

    public void setAdSpace(Adspace adspace) {
        this.adspace = adspace;
    }


}
