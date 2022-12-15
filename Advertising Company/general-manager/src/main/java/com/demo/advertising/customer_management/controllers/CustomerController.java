package com.demo.advertising.customer_management.controllers;

import com.demo.advertising.customer_management.services.CustomerService;
import com.demo.advertising.customer_management.data.entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/com/demo/customer_management/models", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerEntity> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping
    public void registerNewCustomer(@RequestBody CustomerEntity customer){
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteExistingCustomer(@PathVariable("customerId") Long id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(
        @PathVariable("customerId") Long customerId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email) {
        customerService.updateCustomer(customerId, name, email);
    }

}
