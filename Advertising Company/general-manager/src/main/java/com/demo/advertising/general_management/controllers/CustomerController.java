package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.responses.CreateCustomerResponse;
import com.demo.advertising.general_management.data.entities.CardEntity;
import com.demo.advertising.general_management.data.entities.PayPalEntity;
import com.demo.advertising.general_management.services.models.Customer;
import com.demo.advertising.general_management.services.CustomerService;
import com.demo.advertising.general_management.services.models.Notification.INotification;
import com.demo.advertising.general_management.services.models.Notification.Notification;
import com.demo.advertising.general_management.services.models.Notification.SMSDecorator;
import com.demo.advertising.general_management.services.models.Notification.WhatsAppDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping(value = "/Customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateCustomerResponse> registerCustomer(@Valid @RequestBody Customer customer){

        String message;
        customerService.createCustomer(customer);

        if(customer.getSubscribe().equalsIgnoreCase("yes")){
            INotification notification = new WhatsAppDecorator(customer, new SMSDecorator(customer, new Notification(customer)));
            message = notification.sendMessage("Notification success - hello!");
        } else {
            message = "Notification will not be sent!";
        }

        return ResponseEntity.ok(new CreateCustomerResponse(message));
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
    public void updateCustomer(@PathVariable("customerId") String customerId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) String phoneNumber,
                               @RequestBody(required = false) CardEntity card) {

        customerService.updateCustomer(customerId, name, email, phoneNumber, card);
    }

    @DeleteMapping(value = "Customer/{customerId}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("customerId") String customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
    }

}
