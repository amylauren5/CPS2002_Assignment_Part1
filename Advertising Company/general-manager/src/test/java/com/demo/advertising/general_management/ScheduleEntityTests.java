package com.demo.advertising.general_management;

import com.demo.advertising.general_management.data.entities.ScheduleEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ScheduleEntityTests {

    static ScheduleEntity scheduleToGet;
    static ScheduleEntity scheduleToSet;

    @BeforeAll
    public static void setup(){
        scheduleToGet = new ScheduleEntity(LocalDate.of(2026, 5, 6),"spaceId");

        scheduleToSet = new ScheduleEntity();
    }

    // schedule entity getters and setters

    @Test
    public void getScheduleEntityDateTest(){
        LocalDate date = scheduleToGet.getDate();
        Assertions.assertEquals(LocalDate.of(2026, 5, 6), date);
    }

    @Test
    public void setScheduleEntityDateTest(){
        scheduleToSet.setDate(LocalDate.of(2024, 2, 6));
        Assertions.assertEquals(LocalDate.of(2024, 2, 6),  scheduleToSet.getDate());
    }

    @Test
    public void getScheduleEntitySpaceIdTest(){
        String spaceId = scheduleToGet.getSpaceId();
        Assertions.assertEquals("spaceId", spaceId);
    }

    @Test
    public void setCustomerEntitySpaceIdTest(){
        scheduleToSet.setSpaceId("spaceId2");
        Assertions.assertEquals("spaceId2",  scheduleToSet.getSpaceId());
    }


}
