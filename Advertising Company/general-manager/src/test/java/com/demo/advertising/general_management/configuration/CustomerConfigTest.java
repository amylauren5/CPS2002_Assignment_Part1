package com.demo.advertising.general_management.configuration;

import com.demo.advertising.general_management.configuration.CustomerConfig;
import com.demo.advertising.general_management.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomerConfigTest {

    ApplicationContextRunner context = new ApplicationContextRunner()
            .withUserConfiguration(CustomerConfig.class);


    @Test
    public void configTest(){
        context.run(it -> {
            assertThat(it).hasSingleBean(CustomerService.class);
        });
    }
}
