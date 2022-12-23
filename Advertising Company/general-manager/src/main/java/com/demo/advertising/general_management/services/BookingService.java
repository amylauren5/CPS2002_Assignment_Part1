package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.data.entities.BookingEntity;
import com.demo.advertising.general_management.data.repositories.BookingsRepository;
import com.demo.advertising.general_management.services.models.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    ModelMapper mapper;

    public String submitBooking(Booking booking) {
        BookingEntity bookingEntity = mapper.map(booking, BookingEntity.class);
        bookingEntity.setBookingsId(UUID.randomUUID().toString());
        bookingEntity = bookingsRepository.save(bookingEntity);
        return bookingEntity.getBookingsId();
    }

    public Booking getBooking(String orderId, String customerId) {
        BookingEntity bookingEntityToFind = new BookingEntity();
        bookingEntityToFind.setCustomerId(customerId);
        bookingEntityToFind.setBookingsId(orderId);

        Optional<BookingEntity> retrievedBookingEntity =
                bookingsRepository.findOne(Example.of(bookingEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedBookingEntity.isEmpty()) return null;

        return mapper.map(retrievedBookingEntity.get(), Booking.class);
    }
}
