package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.services.AdSpaceService;
import com.demo.advertising.general_management.services.models.AdSpace;
import com.demo.advertising.general_management.services.models.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(AdSpaceController.class)
class AdSpaceControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private AdSpaceService adSpaceService;
    @MockBean
    private ModelMapper mapper;
    static AdSpace adSpace1;
    static AdSpace adSpace2;
    static AdSpace adSpace3;

    @BeforeAll
    public static void setup(){
        adSpace1= new AdSpace.AdSpaceBuilder("High","bus","5","10","5000","15","45")
                .setBusRoute("235").build();
        adSpace2= new AdSpace.AdSpaceBuilder("High","bench","15","10","1000","15","45")
                .setSpaceId("2").setLocation("gharghur").build();
        adSpace3= new AdSpace.AdSpaceBuilder("High","bus","10","20","10000","25","100")
                .setSpaceId("3").setBusRoute("31").build();
    }

    @Test
    public void canCreateAdSpace() throws Exception{

        MockHttpServletResponse result = mvc.perform(post("/AdSpace/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .param("popularity", "High")
                        .param("type", "bus")
                        .param("length", "5")
                        .param("width", "10")
                        .param("price", "5000")
                        .param("minWeeks", "15")
                        .param("maxWeeks", "45")
                        .param("busRoute", "235")
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void getAdSpaceByType() throws Exception{

        mvc.perform(MockMvcRequestBuilders
                        .get("/AdSpace/{Filter}", "bus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("FilterBy","type")
                        .header("Filter","bus")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void deleteAdSpaceTest() throws Exception{
        mvc.perform(MockMvcRequestBuilders.delete("/AdSpace/{SpaceId}","1")
                        .header("SpaceId","1"))
                .andExpect(status().isOk());
    }
}