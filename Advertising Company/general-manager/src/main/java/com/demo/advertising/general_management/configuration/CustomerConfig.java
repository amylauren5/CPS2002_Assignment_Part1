package com.demo.advertising.general_management.configuration;

import com.demo.advertising.general_management.data.entities.CardEntity;
import com.demo.advertising.general_management.data.entities.CustomerEntity;
import com.demo.advertising.general_management.data.entities.PayPalEntity;
import com.demo.advertising.general_management.data.repositories.CustomerRepository;
import com.demo.advertising.general_management.services.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Autowired
    ModelMapper mapper;

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer amy = new Customer(
                    "1",
                    "Amy",
                    "amy@gmail.com",
                    "21908546",
                    new CardEntity("string","string","string"),
                    new PayPalEntity("amy","pass123"),
                    "no"
            );

            CustomerEntity customerEntity = mapper.map(amy, CustomerEntity.class);

            customerRepository.save(customerEntity);

        };
    }
}

