package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.requests.CreateCustomerRequest;
import com.demo.advertising.general_management.controllers.responses.CreateCustomerResponse;
import com.demo.advertising.general_management.controllers.responses.GetCustomerResponse;
import com.demo.advertising.general_management.services.models.Customer;
import com.demo.advertising.general_management.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerManagerService;

    @Autowired
    ModelMapper mapper;

    @PostMapping(value = "customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateCustomerResponse> submitCustomer(@RequestHeader(name = "X-Customer-Id") String CustomerId, @RequestBody CreateCustomerRequest customerRequest) {

        Customer customerSubmission = mapper.map(customerRequest, Customer.class);
        customerSubmission.setCustomerId(CustomerId);

        String newCustomerId = customerManagerService.createCustomer(customerSubmission);

        return ResponseEntity.ok(new CreateCustomerResponse(newCustomerId));
    }

    @GetMapping(value = "customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetCustomerResponse> getCustomer(@RequestHeader(name = "X-Customer-Id") String CustomerId, @PathVariable String newCustomerId) {

        Customer customer = customerManagerService.getCustomer(CustomerId);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        GetCustomerResponse getCustomerResponse = mapper.map(customer, GetCustomerResponse.class);
        return ResponseEntity.ok(getCustomerResponse);
    }

    /*

    @DeleteMapping(value = "customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<>deleteCustomer(@PathVariable("customerId") Long id) {
        customerService.deleteCustomer(id);
    }

     */


    /*

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

     */

}
