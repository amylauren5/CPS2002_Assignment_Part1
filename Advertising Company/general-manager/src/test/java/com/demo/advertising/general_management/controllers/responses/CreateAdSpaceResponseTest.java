package com.demo.advertising.general_management.controllers.responses;

import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.services.models.AdSpace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateAdSpaceResponseTest {

    static CreateAdSpaceResponse spaceIdToGet;
    static CreateAdSpaceResponse spaceIdToSet;

    @BeforeAll
    public static void setup(){
        spaceIdToGet = new CreateAdSpaceResponse("123abc");
        spaceIdToSet = new CreateAdSpaceResponse();
    }

    @Test
    void getSpaceId() {
        String spaceId = spaceIdToGet.getSpaceId();
        Assertions.assertEquals("123abc", spaceId);
    }

    @Test
    void setSpaceId() {
        spaceIdToSet.setSpaceId("123abc");
        Assertions.assertEquals("123abc",  spaceIdToGet.getSpaceId());
    }

}