package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.data.entities.CustomerEntity;
import com.demo.advertising.general_management.data.repositories.CustomerRepository;
import com.demo.advertising.general_management.services.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    ModelMapper mapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    //create customer
    public void createCustomer(Customer customer) {

        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);

        Optional<CustomerEntity> customerOptional = customerRepository
                .findCustomerByCustomerId(customerEntity.getCustomerId());

        if(customerOptional.isPresent()){
            throw new IllegalStateException("Customer ID already exists!");
        }

        customerRepository.save(customerEntity);
    }

    //read customer
    public Customer getCustomer(String customerId) {
        CustomerEntity customerEntityToFind = new CustomerEntity();
        customerEntityToFind.setCustomerId(customerId);

        Optional<CustomerEntity> retrievedCustomerEntity =
                customerRepository.findOne(Example.of(customerEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedCustomerEntity.isEmpty()) return null;

        return mapper.map(retrievedCustomerEntity.get(), Customer.class);
    }

    //update customer
    @Transactional
    public void updateCustomer(String customerId, String name, String email, String paymentDetails, String phoneNumber) {

        CustomerEntity customer = customerRepository.findById(customerId).orElseThrow(
                () -> new IllegalStateException("Customer ID " + customerId + " does not exist!")
        );

        if(name != null && name.length() > 0 && !Objects.equals(customer.getName(), name)){
            customer.setName(name);
        }

        if(email != null && email.length() > 0
                && !Objects.equals(customer.getEmail(), email)){
            Optional<CustomerEntity> customerOptional = customerRepository
                    .findCustomerByEmail(email);

            if(customerOptional.isPresent()){
                throw new IllegalStateException("Email taken!");
            }
            customer.setEmail(email);
        }

        if(paymentDetails != null && paymentDetails.length() > 0 && !Objects.equals(customer.getPaymentDetails(), paymentDetails)){
            customer.setPaymentDetails(paymentDetails);
        }

        if(phoneNumber != null && !Objects.equals(customer.getPhoneNumber(), phoneNumber)){
            customer.setPhoneNumber(phoneNumber);
        }

    }

    //delete customer
    public void deleteCustomer(String customerId){
        boolean exists = customerRepository.existsById(customerId);

        if(!exists){
            throw new IllegalStateException("Customer with ID " + customerId + "does not exist!");
        }

        customerRepository.deleteById(customerId);
    }
}
