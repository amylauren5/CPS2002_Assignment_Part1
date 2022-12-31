package com.demo.advertising.general_management.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ScheduleEntity {

    @Id
    LocalDate date;
    String spaceId;

    public ScheduleEntity(LocalDate date, String spaceId){
        this.date = date;
        this.spaceId = spaceId;
    }

    public ScheduleEntity(){

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
