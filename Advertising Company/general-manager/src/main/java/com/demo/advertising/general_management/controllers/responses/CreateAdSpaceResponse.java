package com.demo.advertising.general_management.controllers.responses;

public class CreateAdSpaceResponse {

    private String spaceId;

    public CreateAdSpaceResponse(String spaceId) {
        this.spaceId = spaceId;
    }

    public CreateAdSpaceResponse() {
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }
}

