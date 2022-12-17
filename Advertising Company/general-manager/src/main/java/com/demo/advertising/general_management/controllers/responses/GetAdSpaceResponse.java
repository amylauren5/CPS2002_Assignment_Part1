package com.demo.advertising.general_management.controllers.responses;

public class GetAdSpaceResponse {

    String newSpaceId;

    public GetAdSpaceResponse(String newSpaceId) {
        this.newSpaceId = newSpaceId;
    }

    public GetAdSpaceResponse() {
    }

    public String getNewSpaceId() {
        return newSpaceId;
    }

    public void setNewSpaceId(String newSpaceId) {
        this.newSpaceId = newSpaceId;
    }
}
