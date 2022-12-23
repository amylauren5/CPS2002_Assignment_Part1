package com.demo.advertising.general_management.controllers.responses;
import com.demo.advertising.general_management.services.models.Adspace;

public class GetAdSpaceResponse {

    private Adspace adspace;
    private String SpaceId;

    public GetAdSpaceResponse(Adspace adspace, String SpaceId) {
        this.adspace = adspace;
        this.SpaceId = SpaceId;
    }

    public GetAdSpaceResponse() {
    }

    public Adspace getAdspace() {
        return adspace;
    }

    public void setAdspace(Adspace adspace) {
        this.adspace = adspace;
    }

    public String getSpaceId() {
        return SpaceId;
    }

    public void setSpaceId(String spaceId) {
        SpaceId = spaceId;
    }
}
