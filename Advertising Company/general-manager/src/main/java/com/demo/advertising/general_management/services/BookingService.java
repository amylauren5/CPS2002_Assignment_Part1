package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.data.entities.BookingEntity;
import com.demo.advertising.general_management.data.entities.ScheduleEntity;
import com.demo.advertising.general_management.data.repositories.BookingsRepository;
import com.demo.advertising.general_management.data.repositories.ScheduleRepository;
import com.demo.advertising.general_management.services.models.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    ModelMapper mapper;

    public String submitBooking(Booking booking) {
        BookingEntity bookingEntity = mapper.map(booking, BookingEntity.class);
        bookingEntity.setBookingId(UUID.randomUUID().toString());
        bookingEntity = bookingsRepository.save(bookingEntity);
        return bookingEntity.getBookingId();
    }

    public Booking getBooking(String bookingId) {
        BookingEntity bookingEntityToFind = new BookingEntity();
        bookingEntityToFind.setBookingId(bookingId);

        Optional<BookingEntity> retrievedBookingEntity =
                bookingsRepository.findOne(Example.of(bookingEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedBookingEntity.isEmpty()) return null;

        return mapper.map(retrievedBookingEntity.get(), Booking.class);
    }

    public boolean checkBookingAvailability(String startingDate, String SpaceId, int noOfWeeks){

        //converts string to LocalDate
        LocalDate startingDateConverted = LocalDate.parse(startingDate);

        //gets current date
        LocalDate today = java.time.LocalDate.now();

        //checks if date has passed
        if(startingDateConverted.isBefore(today) || getSchedule(startingDateConverted, SpaceId, noOfWeeks)){
            return false;
        }
        return true;
    }

    public boolean getSchedule(LocalDate startingDate, String SpaceId, int noOfWeeks){

        ScheduleEntity scheduleEntityToFind = new ScheduleEntity();
        scheduleEntityToFind.setSpaceId(SpaceId);

        boolean booked=false;

        LocalDate endDate = startingDate.plusDays(noOfWeeks* 7L);

        for(LocalDate date= startingDate; date.isBefore(endDate); date=date.plusDays(1)) {
            scheduleEntityToFind.setDate(date);

            Optional<ScheduleEntity> retrievedScheduleEntity =
                    scheduleRepository.findOne(Example.of(scheduleEntityToFind, ExampleMatcher.matchingAll()));

            if (retrievedScheduleEntity.isPresent()) {
                booked = true;
                break;
            }
        }

        if (!booked){ //create schedule

            for(LocalDate date= startingDate; date.isBefore(endDate); date=date.plusDays(1)) {
                ScheduleEntity scheduleEntity = new ScheduleEntity();
                scheduleEntity.setDate(date);
                scheduleEntity.setSpaceId(SpaceId);
                scheduleRepository.save(scheduleEntity);
            }
        }

        return booked;
    }

}
