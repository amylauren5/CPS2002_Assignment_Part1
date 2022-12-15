package com.demo.advertising.customer_management.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapperFactory() { return new ModelMapper(); }

}
