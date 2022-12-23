package com.demo.advertising.general_management.data.repositories;

import com.demo.advertising.general_management.data.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookingsRepository extends JpaRepository<BookingEntity, String> {

    @Query("SELECT b FROM BookingEntity b WHERE b.bookingId = ?1")
    Optional<BookingEntity> findBookingById(String bookingId);
}
