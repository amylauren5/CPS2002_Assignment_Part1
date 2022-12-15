package com.demo.advertising.customer_management.data.repositories;

import com.demo.advertising.customer_management.data.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("SELECT c FROM CustomerEntity c WHERE c.name = ?1")
    Optional<CustomerEntity> findCustomerByName(String name);

    @Query("SELECT c FROM CustomerEntity c WHERE c.email = ?1")
    Optional<CustomerEntity> findCustomerByEmail(String email);
}