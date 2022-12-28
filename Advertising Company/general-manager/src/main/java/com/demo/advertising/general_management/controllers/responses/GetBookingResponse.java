package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.controllers.requests.AdSpace;
import com.demo.advertising.general_management.services.AdSpaceService;
import com.demo.advertising.general_management.services.models.Adspace;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class GetBookingResponse {

    String customerId;
    String bookingId;
    private String SpaceId;
    private String startingDate;
    private String noOfWeeks;
    private List<Adspace> adspace;


    public GetBookingResponse(String customerId, String bookingId, String SpaceId, String startingDate, String noOfWeeks, List<Adspace> adspace) {
        this.customerId = customerId;
        this.bookingId = bookingId;
        this.SpaceId = SpaceId;
        this.startingDate= startingDate;
        this.noOfWeeks = noOfWeeks;
        this.adspace = adspace;
    }

    public GetBookingResponse() {
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

    public List<Adspace> getAdspace() {
        return adspace;
    }

    public void setAdspace(List<Adspace> adspace) {
        this.adspace = adspace;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

}
