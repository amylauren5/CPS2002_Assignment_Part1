package com.demo.advertising.general_management.data.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdSpaceEntityTest {

    static AdSpaceEntity adSpaceToGet;
    static AdSpaceEntity adSpaceToSet;

    @BeforeAll
    public static void setup(){
        adSpaceToGet = new AdSpaceEntity("123abc","High","bus","1000","5000","15","45","235","gharghur","9");
        adSpaceToSet = new AdSpaceEntity();
    }

    @Test
    void getSpaceId() {
        String spaceId = adSpaceToGet.getSpaceId();
        Assertions.assertEquals("123abc", spaceId);
    }

    @Test
    void setSpaceId() {
        adSpaceToSet.setSpaceId("123abc");
        Assertions.assertEquals("123abc",  adSpaceToSet.getSpaceId());
    }

    @Test
    void getPopularity() {
        String popularity = adSpaceToGet.getPopularity();
        Assertions.assertEquals("High", popularity);
    }

    @Test
    void setPopularity() {
        adSpaceToSet.setPopularity("High");
        Assertions.assertEquals("High",  adSpaceToSet.getPopularity());
    }

    @Test
    void getType() {
        String type = adSpaceToGet.getType();
        Assertions.assertEquals("bus", type);
    }

    @Test
    void setType() {
        adSpaceToSet.setType("bus");
        Assertions.assertEquals("bus",  adSpaceToSet.getType());
    }

    @Test
    void getSize() {
        String size = adSpaceToGet.getSize();
        Assertions.assertEquals("1000", size);
    }

    @Test
    void setSize() {
        adSpaceToSet.setSize("1000");
        Assertions.assertEquals("1000",  adSpaceToSet.getSize());
    }

    @Test
    void getPrice() {
        String price = adSpaceToGet.getPrice();
        Assertions.assertEquals("5000", price);
    }

    @Test
    void setPrice() {
        adSpaceToSet.setPrice("5000");
        Assertions.assertEquals("5000",  adSpaceToSet.getPrice());
    }

    @Test
    void getMinWeeks() {
        String minWeeks = adSpaceToGet.getMinWeeks();
        Assertions.assertEquals("15", minWeeks);
    }

    @Test
    void setMinWeeks() {
        adSpaceToSet.setMinWeeks("15");
        Assertions.assertEquals("15",  adSpaceToSet.getMinWeeks());
    }

    @Test
    void getMaxWeeks() {
        String maxWeeks = adSpaceToGet.getMaxWeeks();
        Assertions.assertEquals("45", maxWeeks);
    }

    @Test
    void setMaxWeeks() {
        adSpaceToSet.setMaxWeeks("45");
        Assertions.assertEquals("45",  adSpaceToSet.getMaxWeeks());
    }

    @Test
    void getBusRoute() {
        String busRoute = adSpaceToGet.getBusRoute();
        Assertions.assertEquals("235", busRoute);
    }

    @Test
    void setBusRoute() {
        adSpaceToSet.setBusRoute("235");
        Assertions.assertEquals("235",  adSpaceToSet.getBusRoute());
    }

    @Test
    void getLocation() {
        String location = adSpaceToGet.getLocation();
        Assertions.assertEquals("gharghur", location);
    }

    @Test
    void setLocation() {
        adSpaceToSet.setLocation("gharghur");
        Assertions.assertEquals("gharghur",  adSpaceToSet.getLocation());
    }

    @Test
    void getIndex() {
        String index = adSpaceToGet.getIndex();
        Assertions.assertEquals("9", index);
    }

    @Test
    void setIndex() {
        adSpaceToSet.setIndex("9");
        Assertions.assertEquals("9",  adSpaceToSet.getIndex());
    }
}