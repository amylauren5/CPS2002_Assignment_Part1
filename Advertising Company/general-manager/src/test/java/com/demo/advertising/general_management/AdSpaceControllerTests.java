package com.demo.advertising.general_management;

import com.demo.advertising.general_management.controllers.AdSpaceController;
import com.demo.advertising.general_management.controllers.requests.CreateAdSpaceRequest;

import com.demo.advertising.general_management.services.AdSpaceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(AdSpaceController.class)
public class AdSpaceControllerTests {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private AdSpaceService adSpaceService;
    @MockBean
    private ModelMapper mapper;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*@Test
    public void canCreateAdSpace() throws Exception{

        CreateAdSpaceRequest adSpaceRequest = new CreateAdSpaceRequest("1000", "bus", "500", "1000", "", "45", "15", "50");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(adSpaceRequest);

        MockHttpServletResponse result = mvc.perform(post("/AdSpace/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json)
                        .accept("application/json"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .andDo(print());

        String response = result.getResponse().getContentAsString();
        System.out.print(response);
    }*/

/*    @Test
    void updateFieldsTest() throws Exception {
        String Filter;
        String FilterBy;
        UpdateModel updateModel = new UpdateModel();
        response.add(updateModel);
        when(adSpaceService.update(anyList()))
                .thenReturn(String.valueOf(response));

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(response);

        mockMvc.perform(
                        MockMvcRequestBuilders.put("/api/update")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(json)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }*/


/*    public void createAdSpaceTest() throws Exception {
        // when
        MockHttpServletResponse response = mvc.perform(
                post("/AdSpace/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonCreateAdSpaceRequest
                                .write(new CreateAdSpaceRequest("1000", "bus", "500", "1000", "", "45", "15", "50"))
                                .getJson()))
                .andReturn()
                .getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        System.out.print(response.getContentAsString());
    }*/
/*

    @Test
    public void getAdSpaceWhenExistsTest() throws Exception {

        String SpaceId = mvc.perform(
                        post("/AdSpace/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonCreateAdSpaceRequest
                                        .write(new CreateAdSpaceRequest("1000", "bus", "500", "1000", "", "45", "15", "50"))
                                        .getJson()))
                .andReturn()
                .getResponse()
                .getContentAsString();

        MockHttpServletResponse response = mvc.perform(
                get("/AdSpace/{Filter}/SpaceId",SpaceId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonGetAdSpaceResponse.write(new GetAdSpaceResponse("1000", "bus", "500", "1000", "", "45", "15", "50")).getJson()
        );
    }
*/


/*    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
        // given
        given(adSpaceService.getAdSpace("SpaceId",1))
                .willReturn(new SuperHero("Rob", "Mannon", "RobotMan"));

        // when
        MockHttpServletResponse response = mvc.perform(
                        get("/superheroes/2")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonSuperHero.write(new SuperHero("Rob", "Mannon", "RobotMan")).getJson()
        );
    }*/

}
