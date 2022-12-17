package com.demo.advertising.general_management.controllers.responses;

public class CreateAdSpaceResponse {

    private String newSpaceId;

    public CreateAdSpaceResponse(String newSpaceId) {
        this.newSpaceId = newSpaceId;
    }

    public CreateAdSpaceResponse() {
    }

    public String getNewSpaceId() {
        return newSpaceId;
    }

    public void setNewSpaceId(String newSpaceId) {
        this.newSpaceId = newSpaceId;
    }

}