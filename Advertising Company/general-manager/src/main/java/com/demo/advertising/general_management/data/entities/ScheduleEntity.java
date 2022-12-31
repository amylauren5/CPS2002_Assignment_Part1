package com.demo.advertising.general_management.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ScheduleEntity {

    @Id
    LocalDate date;
    String SpaceId;

    public ScheduleEntity(LocalDate date, String SpaceId){
        this.date = date;
        this.SpaceId = SpaceId;
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
        return SpaceId;
    }

    public void setSpaceId(String SpaceId) {
        this.SpaceId = SpaceId;
    }
}
