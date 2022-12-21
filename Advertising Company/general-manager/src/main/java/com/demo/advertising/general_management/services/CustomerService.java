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

    //create resource
    public void createCustomer(Customer customer) {
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }

    //read resource
    public Customer getCustomers(String customerId) {
        CustomerEntity customerEntityToFind = new CustomerEntity();
        customerEntityToFind.setCustomerId(customerId);

        Optional<CustomerEntity> retrievedCustomerEntity =
                customerRepository.findOne(Example.of(customerEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedCustomerEntity.isEmpty()) return null;

        return mapper.map(retrievedCustomerEntity.get(), Customer.class);
    }

    public void deleteCustomer(String customerId){
        boolean exists = customerRepository.existsById(customerId);

        if(!exists){
            throw new IllegalStateException("Customer with id " + customerId + "does not exist!");
        }

        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(String customerId, String name, String email) {

        CustomerEntity customer = customerRepository.findById(customerId).orElseThrow(
                () -> new IllegalStateException("Customer with id " + customerId + " does not exist!")
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

    }

    /*

    public List<CustomerEntity> getCustomers() {
        return customerRepository.findAll();
    }

    public void createCustomer(CustomerEntity customer) {
        Optional<CustomerEntity> customerOptional = customerRepository
                .findCustomerByName(customer.getName());

        if(customerOptional.isPresent()){
            throw new IllegalStateException("Name taken!");
        }

        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId){
        boolean exists = customerRepository.existsById(customerId);
        if(!exists){
            throw new IllegalStateException("Customer with id " + customerId + "does not exist!");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(
            Long customerId,
            String name,
            String email) {

        CustomerEntity customer = customerRepository.findById(customerId).orElseThrow(
                () -> new IllegalStateException("Customer with id " + customerId + " does not exist!")
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

    }

     */

}
