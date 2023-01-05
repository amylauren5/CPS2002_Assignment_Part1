package com.demo.advertising.general_management.controllers;

import com.demo.advertising.general_management.controllers.responses.CreateCustomerResponse;
import com.demo.advertising.general_management.data.entities.CardEntity;
import com.demo.advertising.general_management.data.entities.PayPalEntity;
import com.demo.advertising.general_management.services.PaymentService;
import com.demo.advertising.general_management.services.models.Customer;
import com.demo.advertising.general_management.services.CustomerService;
import com.demo.advertising.general_management.services.models.Notification.INotification;
import com.demo.advertising.general_management.services.models.Notification.Notification;
import com.demo.advertising.general_management.services.models.Notification.SMSDecorator;
import com.demo.advertising.general_management.services.models.Notification.WhatsAppDecorator;
import com.demo.advertising.general_management.services.models.Payment.PaymentByCardStrategy;
import com.demo.advertising.general_management.services.models.Payment.PaymentByPayPalStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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

        PaymentService paymentService = new PaymentService();

        List<String> notificationList = new ArrayList<>();
        String paymentMessage;

        customerService.createCustomer(customer);

        if(customer.getSubscribe().equalsIgnoreCase("yes")){
            INotification notification = new WhatsAppDecorator(customer, new SMSDecorator(customer, new Notification(customer)));
            notificationList = notification.sendMessage(notificationList, "Notification success - hello!");
        } else {
            notificationList.add("Notification will not be sent!");
        }

        if(!customer.getCardDetails().getCardNumber().equals("string")){
            //customer will pay by card
            paymentService.setStrategy(new PaymentByCardStrategy());
            paymentMessage = paymentService.processPaymentMethod();
        } else if(!customer.getPaypalDetails().getUsername().equals("string")){
            //customer will pay by PayPal
            paymentService.setStrategy(new PaymentByPayPalStrategy());
            paymentMessage = paymentService.processPaymentMethod();
        } else {
            paymentMessage = "Something went wrong!";
        }


        return ResponseEntity.ok(new CreateCustomerResponse(notificationList, paymentMessage));
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
