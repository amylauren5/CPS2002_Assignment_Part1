package com.demo.advertising.general_management.controllers.requests;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

public class SubmitBookingRequest {

    private String SpaceId;
    private LocalDate startingDate;
    private int noOfWeeks;

    public SubmitBookingRequest(String SpaceId,LocalDate startingDate, int noOfWeeks) {
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

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public int getNoOfWeeks() {
        return noOfWeeks;
    }

    public void setNoOfWeeks(int noOfWeeks) {
        this.noOfWeeks = noOfWeeks;
    }
}
