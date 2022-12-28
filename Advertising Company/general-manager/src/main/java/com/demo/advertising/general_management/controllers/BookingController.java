package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.requests.SubmitBookingRequest;
import com.demo.advertising.general_management.controllers.responses.GetBookingResponse;
import com.demo.advertising.general_management.controllers.responses.SubmitBookingResponse;
import com.demo.advertising.general_management.services.CustomerService;
import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.services.AdSpaceService;
import com.demo.advertising.general_management.services.BookingService;
import com.demo.advertising.general_management.services.models.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    AdSpaceService adSpaceService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubmitBookingResponse> submit(@RequestHeader(name = "X-Customer-Id") String customerId, @RequestBody SubmitBookingRequest request) {

        if(customerService.getCustomer(customerId).isEmpty())

        Booking bookingSubmission = mapper.map(request, Booking.class);
        bookingSubmission.setCustomerId(customerId);

        String bookingId = bookingService.submitBooking(bookingSubmission);

        return ResponseEntity.ok(new SubmitBookingResponse(bookingId));
    }

    @GetMapping(value = "bookings/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetBookingResponse> get(@RequestHeader String bookingId) {

        Booking booking = bookingService.getBooking(bookingId);

        if (booking == null) {
            return ResponseEntity.notFound().build();
        }

        GetBookingResponse getBookingResponse = mapper.map(booking, GetBookingResponse.class);

        String SpaceId = getBookingResponse.getSpaceId();
        List<Adspace> adspace = adSpaceService.getAdSpace("SpaceId",SpaceId);
        getBookingResponse.setAdspace(adspace);

        int weeks = Integer.parseInt(getBookingResponse.getNoOfWeeks());
        int cost = Integer.parseInt(adspace.get(0).getPrice());

        String price = Integer.toString(weeks*cost);
        getBookingResponse.setPrice(price);

        return ResponseEntity.ok(getBookingResponse);
    }
}
