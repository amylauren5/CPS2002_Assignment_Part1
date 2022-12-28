package com.demo.advertising.general_management.controllers.requests;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

public class SubmitBookingRequest {

    private String SpaceId;
    private String startingDate;
    private String noOfWeeks;

    public SubmitBookingRequest(String SpaceId,String startingDate, String noOfWeeks) {
        this.SpaceId = SpaceId;
        this.startingDate = startingDate;
        this.noOfWeeks = noOfWeeks;
    }

    public SubmitBookingRequest() {
    }

    public String getSpaceId() {
        return SpaceId;
    }

    public void setSpaceId(String spaceId) {
        SpaceId = spaceId;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getNoOfWeeks() {
        return noOfWeeks;
    }

    public void setNoOfWeeks(String noOfWeeks) {
        this.noOfWeeks = noOfWeeks;
    }
}
