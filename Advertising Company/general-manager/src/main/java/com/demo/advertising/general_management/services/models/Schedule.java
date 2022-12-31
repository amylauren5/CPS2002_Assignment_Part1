package com.demo.advertising.general_management.services.models;

import java.time.LocalDate;

public class Schedule {

    LocalDate date;

    String spaceId;

    public Schedule(LocalDate date, String spaceId){
        this.date = date;
        this.spaceId = spaceId;
    }

    public Schedule(){

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }
}
