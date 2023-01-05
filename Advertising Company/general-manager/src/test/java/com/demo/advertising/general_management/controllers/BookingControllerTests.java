package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.BookingController;
import com.demo.advertising.general_management.controllers.requests.CreateAdSpaceRequest;
import com.demo.advertising.general_management.controllers.requests.SubmitBookingRequest;
import com.demo.advertising.general_management.services.BookingService;
import com.demo.advertising.general_management.services.CustomerService;
import com.demo.advertising.general_management.services.models.Booking;
import com.demo.advertising.general_management.services.models.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
@WebMvcTest(BookingController.class)
public class BookingControllerTests {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private ModelMapper mapper;
    @MockBean
    BookingService bookingService;
    @Autowired
    private JacksonTester<SubmitBookingRequest> jsonBooking;

    @Test
    public void createBookingTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/booking")
                        .content(jsonBooking.write(new SubmitBookingRequest()).getJson())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
