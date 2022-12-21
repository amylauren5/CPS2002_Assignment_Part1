package com.demo.advertising.general_management.data.repositories;

import com.demo.advertising.general_management.data.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<BookingEntity, String> {

}
