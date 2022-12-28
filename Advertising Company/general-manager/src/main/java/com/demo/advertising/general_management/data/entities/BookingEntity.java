package com.demo.advertising.general_management.data.entities;

import com.demo.advertising.general_management.services.models.Adspace;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class BookingEntity {

    private String SpaceId;
    private String customerId;
    @Id
    private String bookingId;
    private LocalDate startingDate;
    //private int minWeeks;
    private int noOfWeeks;

    public String getSpaceId() {
        return SpaceId;
    }

    public void setSpaceId(String SpaceId) {
        this.SpaceId = SpaceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBookingsId() {
        return bookingId;
    }

    public void setBookingsId(String bookingId) {
        this.bookingId = bookingId;
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
