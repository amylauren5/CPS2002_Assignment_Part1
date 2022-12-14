package com.demo.advertising.general_management.services.models;

import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdSpaceTest {

    static AdSpace adSpaceToGet;

    @BeforeAll
    public static void setup(){
        adSpaceToGet = new AdSpace.AdSpaceBuilder("High","bus","5","10","5000","15","45")
                .setSpaceId("123abc").setBusRoute("235").setLocation("gharghur").setDurationInterval("10").build();
    }

    @Test
    void getSpaceId() {
        String spaceId = adSpaceToGet.getSpaceId();
        Assertions.assertEquals("123abc", spaceId);
    }

    @Test
    void getPopularity() {
        String popularity = adSpaceToGet.getPopularity();
        Assertions.assertEquals("High", popularity);
    }

    @Test
    void getType() {
        String type = adSpaceToGet.getType();
        Assertions.assertEquals("bus", type);
    }

    @Test
    void getLength() {
        String length = adSpaceToGet.getLength();
        Assertions.assertEquals("5", length);
    }

    @Test
    void getWidth() {
        String width = adSpaceToGet.getWidth();
        Assertions.assertEquals("10", width);
    }

    @Test
    void getPrice() {
        String price = adSpaceToGet.getPrice();
        Assertions.assertEquals("5000", price);
    }
    @Test
    void getMinWeeks() {
        String minWeeks = adSpaceToGet.getMinWeeks();
        Assertions.assertEquals("15", minWeeks);
    }

    @Test
    void getMaxWeeks() {
        String maxWeeks = adSpaceToGet.getMaxWeeks();
        Assertions.assertEquals("45", maxWeeks);
    }

    @Test
    void getBusRoute() {
        String busRoute = adSpaceToGet.getBusRoute();
        Assertions.assertEquals("235", busRoute);
    }

    @Test
    void getLocation() {
        String location = adSpaceToGet.getLocation();
        Assertions.assertEquals("gharghur", location);
    }

    @Test
    void getDurationInterval() {
        String durationInterval = adSpaceToGet.getDurationInterval();
        Assertions.assertEquals("10", durationInterval);
    }
}