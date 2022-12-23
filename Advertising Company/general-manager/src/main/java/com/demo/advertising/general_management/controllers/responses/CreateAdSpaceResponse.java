package com.demo.advertising.general_management.controllers.responses;

public class CreateAdSpaceResponse {

    private String SpaceId;

    public CreateAdSpaceResponse(String SpaceId) {
        this.SpaceId = SpaceId;
    }

    public CreateAdSpaceResponse() {
    }

    public String getAdSpaceId() {
        return SpaceId;
    }

    public void setAdSpaceId(String SpaceId) {
        this.SpaceId = SpaceId;
    }
}
