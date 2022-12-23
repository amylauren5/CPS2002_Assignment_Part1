package com.demo.advertising.general_management.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class BookingEntity {

    @ElementCollection
    @CollectionTable(name="AD_SPACES", joinColumns = @JoinColumn(name="BOOKINGS_ID"))
    private List<AdSpaceEntity> adSpaceItems;

    private String customerId;
    @Id
    private String bookingsId;
    private LocalDate startingDate;
    private int minWeeks;
    private int noOfWeeks;

    public List<AdSpaceEntity> getAdSpaceItems() {
        return adSpaceItems;
    }

    public void setAdSpaceItems(List<AdSpaceEntity> adSpaceItems) {
        this.adSpaceItems = adSpaceItems;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBookingsId() {
        return bookingsId;
    }

    public void setBookingsId(String bookingsId) {
        this.bookingsId = bookingsId;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public int getMinWeeks() {
        return minWeeks;
    }

    public void setMinWeeks(int minWeeks) {
        this.minWeeks = minWeeks;
    }

    public int getNoOfWeeks() {
        return noOfWeeks;
    }

    public void setNoOfWeeks(int noOfWeeks) {
        this.noOfWeeks = noOfWeeks;
    }
}
