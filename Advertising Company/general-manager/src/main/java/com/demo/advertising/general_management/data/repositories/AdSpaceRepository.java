package com.demo.advertising.general_management.data.repositories;

import com.demo.advertising.general_management.data.entities.AdSpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdSpaceRepository extends JpaRepository<AdSpaceEntity, String> {
}
