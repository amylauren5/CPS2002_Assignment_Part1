package com.demo.advertising.general_management.data.repositories;

import com.demo.advertising.general_management.data.entities.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, LocalDate>{
}
