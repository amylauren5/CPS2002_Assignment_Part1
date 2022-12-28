package com.demo.advertising.general_management.configuration;

import com.demo.advertising.general_management.data.entities.CustomerEntity;
import com.demo.advertising.general_management.data.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            CustomerEntity amy = new CustomerEntity(
                    "123l",
                    "Amy",
                    "amy@gmail.com",
                    "21908546",
                    "card"
            );

            customerRepository.save(amy);
        };
    }
}
