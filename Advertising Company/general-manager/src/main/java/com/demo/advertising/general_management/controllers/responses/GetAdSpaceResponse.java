package com.demo.advertising.general_management.controllers.responses;
import com.demo.advertising.general_management.controllers.requests.AdSpace;
import com.demo.advertising.general_management.services.models.Adspace;

public class GetAdSpaceResponse {

    private String SpaceId;
    private AdSpace adSpace;

    public GetAdSpaceResponse(String SpaceId, AdSpace adSpace) {
        this.SpaceId = SpaceId;
        this.adSpace = adSpace;
    }

    public GetAdSpaceResponse() {
    }

    public AdSpace getAdSpace() {
        return adSpace;
    }

    public void setAdSpace(AdSpace adSpace) {
        this.adSpace = adSpace;
    }

    public String getSpaceId() {
        return SpaceId;
    }

    public void setSpaceId(String spaceId) {
        SpaceId = spaceId;
    }
}
