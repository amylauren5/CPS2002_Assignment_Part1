package com.demo.advertising.general_management.data.entities;

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
    private String startingDate;
    //private int minWeeks;
    private String noOfWeeks;

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
