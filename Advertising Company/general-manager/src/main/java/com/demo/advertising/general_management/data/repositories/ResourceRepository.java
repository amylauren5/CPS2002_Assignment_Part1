package com.demo.advertising.general_management.data.repositories;

import com.demo.advertising.general_management.data.entities.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<ResourceEntity, String> {
}
