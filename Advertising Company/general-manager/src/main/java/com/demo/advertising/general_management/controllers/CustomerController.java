package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.requests.CreateAdSpaceRequest;
import com.demo.advertising.general_management.controllers.responses.CreateAdSpaceResponse;
import com.demo.advertising.general_management.controllers.responses.GetAdSpaceResponse;
import com.demo.advertising.general_management.services.models.Adspace;
import com.demo.advertising.general_management.services.models.Customer;
import com.demo.advertising.general_management.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "customer",produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void registerCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @GetMapping(path = "{customerId}")
    public ResponseEntity<Customer> getCustomer(@RequestHeader String customerId) {

        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(@PathVariable("customerId") String customerId, @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email, @RequestParam(required = false) String paymentDetails,
                               @RequestParam(required = false) String phoneNumber) {
        customerService.updateCustomer(customerId, name, email, paymentDetails, phoneNumber);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") String id) {
        customerService.deleteCustomer(id);
    }

}
