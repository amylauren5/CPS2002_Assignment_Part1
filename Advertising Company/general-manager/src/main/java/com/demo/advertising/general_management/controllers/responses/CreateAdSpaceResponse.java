package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.services.models.Adspace;

public class CreateAdSpaceResponse {

    private Adspace adspace;

    public CreateAdSpaceResponse(Adspace adspace) {
        this.adspace = adspace;
    }

    public CreateAdSpaceResponse() {
    }

    public Adspace getAdSpace() {
        return adspace;
    }

    public void setAdSpace(Adspace adspace) {
        this.adspace = adspace;
    }


}
