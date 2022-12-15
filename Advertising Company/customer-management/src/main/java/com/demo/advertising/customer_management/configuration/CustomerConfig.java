package com.demo.advertising.customer_management.configuration;

import com.demo.advertising.customer_management.data.entities.CustomerEntity;
import com.demo.advertising.customer_management.data.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//jasmine



@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){

        return args -> {

            CustomerEntity sample = new CustomerEntity(
                    1L,
                    "John Doe",
                    "john@gmail.com",
                    LocalDate.of(2002, Month.JUNE, 5),
                    "Visa"
            );

            repository.saveAll(
                    List.of(sample)
            );

        };
    }
}
