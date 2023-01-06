package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.controllers.AdSpaceController;
import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.data.repositories.AdSpaceRepository;
import com.demo.advertising.general_management.services.models.AdSpace;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(AdSpaceService.class)
class AdSpaceServiceTest {

    @MockBean
    AdSpaceService adSpaceService;
    static AdSpace adSpace;

    @BeforeAll
    public static void setup(){
        adSpace = new AdSpace.AdSpaceBuilder("High","bus","1000","5000","15","45","9")
                .setSpaceId("123abc").setBusRoute("235").build();
    }

    @Test
    void createAdSpaceTest() {
        when(adSpaceService.createAdSpace(adSpace)).thenReturn(adSpace.getSpaceId());
        System.out.print(adSpace.getSpaceId());
        String spaceId = adSpaceService.createAdSpace(adSpace);
        Assertions.assertEquals(adSpace.getSpaceId(), spaceId);
    }

    @Test
    void getAdSpace() {

    }

    @Test
    void updateAdSpace() {
    }

    @Test
    void deleteAdSpace() {
    }
}