package com.demo.advertising.general_management.controllers.responses;
import com.demo.advertising.general_management.services.models.Adspace;

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

    public void setAdspace(Adspace adspace) {
        this.adspace = adspace;
    }

}
