package com.demo.advertising.general_management.controllers.responses;
import com.demo.advertising.general_management.services.models.Adspace;

public class GetAdSpaceResponse {

    private Adspace adSpace;

    public GetAdSpaceResponse(Adspace adSpace) {
        this.adSpace = adSpace;
    }

    public GetAdSpaceResponse() {
    }

    public Adspace getAdSpace() {
        return adSpace;
    }

    public void setAdSpace(Adspace adSpace) {
        this.adSpace = adSpace;
    }

}
