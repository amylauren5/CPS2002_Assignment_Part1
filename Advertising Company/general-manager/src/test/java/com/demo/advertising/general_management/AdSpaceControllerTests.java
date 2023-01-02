package com.demo.advertising.general_management;

import com.demo.advertising.general_management.controllers.AdSpaceController;
import com.demo.advertising.general_management.controllers.requests.CreateAdSpaceRequest;

import com.demo.advertising.general_management.services.AdSpaceService;
import com.demo.advertising.general_management.services.models.Customer;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
@RunWith(SpringRunner.class)
@WebMvcTest(AdSpaceController.class)
public class AdSpaceControllerTests {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private AdSpaceService adSpaceService;
    @MockBean
    private ModelMapper mapper;
    @Autowired
    private JacksonTester<CreateAdSpaceRequest> jsonAdSpace;

    @Test
    public void createAdSpaceTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/AdSpace/")
                        .content(jsonAdSpace.write(new CreateAdSpaceRequest("1000", "bus", "500", "1000", "", "45", "15", "50")).getJson())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.SpaceId").exists());
    }
}
