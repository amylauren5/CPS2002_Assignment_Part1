package com.demo.advertising.general_management.controllers.requests;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

public class SubmitBookingRequest {

    private String spaceId;
    private String startingDate;
    private String noOfWeeks;

    public SubmitBookingRequest(String spaceId,String startingDate, String noOfWeeks) {
        this.spaceId = spaceId;
        this.startingDate = startingDate;
        this.noOfWeeks = noOfWeeks;
    }

    public SubmitBookingRequest() {
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        spaceId = spaceId;
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
