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
    private LocalDate startingDate;
    private int noOfWeeks;
    private List<Adspace> adspace;


    public GetBookingResponse(String customerId, String bookingId, String SpaceId, LocalDate startingDate, int noOfWeeks, List<Adspace> adspace) {
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
