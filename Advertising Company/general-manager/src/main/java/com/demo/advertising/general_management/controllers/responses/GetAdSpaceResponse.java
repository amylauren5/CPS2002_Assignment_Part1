package com.demo.advertising.general_management.controllers.responses;
import com.demo.advertising.general_management.controllers.requests.AdSpace;


public class GetAdSpaceResponse {

    private AdSpace adspace;
    private String SpaceId;

    public GetAdSpaceResponse(AdSpace adspace, String SpaceId) {
        this.adspace = adspace;
        this.SpaceId = SpaceId;
    }

    public GetAdSpaceResponse() {
    }

    public AdSpace getAdspace() {
        return adspace;
    }

    public void setAdspace(AdSpace adspace) {
        this.adspace = adspace;
    }

    public String getSpaceId() {
        return SpaceId;
    }

    public void setSpaceId(String spaceId) {
        SpaceId = spaceId;
    }
}
