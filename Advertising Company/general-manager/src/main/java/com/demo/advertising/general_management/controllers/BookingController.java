package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.requests.SubmitBookingRequest;
import com.demo.advertising.general_management.controllers.responses.GetBookingResponse;
import com.demo.advertising.general_management.controllers.responses.SubmitBookingResponse;
import com.demo.advertising.general_management.services.BookingService;
import com.demo.advertising.general_management.services.models.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubmitBookingResponse> submit(@RequestHeader(name = "X-Customer-Id") String customerId, @RequestBody SubmitBookingRequest request) {

        Booking bookingSubmission = mapper.map(request, Booking.class);
        bookingSubmission.setCustomerId(customerId);

        String bookingId = bookingService.submitBooking(bookingSubmission);

        return ResponseEntity.ok(new SubmitBookingResponse(bookingId));
    }

    @GetMapping(value = "bookings/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetBookingResponse> get(@RequestHeader(name = "X-Customer-Id") String customerId, @PathVariable String bookingId) {

        Booking booking = bookingService.getBooking(bookingId, customerId);

        if (booking == null) {
            return ResponseEntity.notFound().build();
        }

        GetBookingResponse getBookingResponse = mapper.map(booking, GetBookingResponse.class);
        return ResponseEntity.ok(getBookingResponse);
    }
}
