package com.demo.advertising.general_management.configuration;

import com.demo.advertising.general_management.data.repositories.AdSpaceRepository;
import com.demo.advertising.general_management.services.models.Adspace;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdSpaceConfig {

    @Bean
    CommandLineRunner commandLineRunner(AdSpaceRepository adSpaceRepository){
        return args -> {
            new Adspace(
                    "high",
                    "bus",
                    "500x400",
                    "1500",
                    "Paola",
                    "120"
            );
        };
    }
}
