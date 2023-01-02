package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.services.models.Customer;
import com.demo.advertising.general_management.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping(value = "/Customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer){
        customerService.createCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }

    @GetMapping(value = "/Customer/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") String customerId) {

        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer);
    }

    @PutMapping(value = "Customer/{customerId}")
    public void updateCustomer(@PathVariable("customerId") String customerId, @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email, @RequestParam(required = false) String paymentDetails,
                               @RequestParam(required = false) String phoneNumber) {
        customerService.updateCustomer(customerId, name, email, paymentDetails, phoneNumber);
    }

    @DeleteMapping(value = "Customer/{customerId}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("customerId") String customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
    }

}
