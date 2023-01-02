package com.demo.advertising.general_management.data.repositories;

import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import com.demo.advertising.general_management.data.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdSpaceRepository extends JpaRepository<AdSpaceEntity, String> {

}
