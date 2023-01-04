package com.demo.advertising.general_management.controllers.responses.GetAdSpace;

import com.demo.advertising.general_management.controllers.responses.GetAdSpace.GetAdSpaceResponse;

public class GetBenchAdResponse extends GetAdSpaceResponse {
    private String location;

    public GetBenchAdResponse(String spaceId, String popularity, String type, String size, String price, String minWeeks, String maxWeeks, String index, String location) {
        super(spaceId, popularity, type, size, price, minWeeks, maxWeeks, index);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
