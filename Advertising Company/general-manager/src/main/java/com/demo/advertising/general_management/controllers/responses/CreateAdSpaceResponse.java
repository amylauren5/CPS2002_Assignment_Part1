package com.demo.advertising.general_management.controllers.responses;

public class CreateAdSpaceResponse {

    private String adSpaceId;

    public CreateAdSpaceResponse(String adSpaceId) {
        this.adSpaceId = adSpaceId;
    }

    public CreateAdSpaceResponse() {
    }

    public String getAdSpaceId() {
        return adSpaceId;
    }

    public void setAdSpaceId(String orderId) {
        this.adSpaceId = adSpaceId;
    }

}
