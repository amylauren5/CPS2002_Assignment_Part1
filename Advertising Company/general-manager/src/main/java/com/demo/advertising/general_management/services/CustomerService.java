package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.data.entities.CustomerEntity;
import com.demo.advertising.general_management.data.repositories.CustomerRepository;
import com.demo.advertising.general_management.services.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    ModelMapper mapper;

    //create resource
    public String createCustomer(Customer customer) {
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        customerEntity.setCustomerId(UUID.randomUUID().toString());
        customerEntity = customerRepository.save(customerEntity);
        return customerEntity.getCustomerId();
    }

    //read resource
    public Customer getCustomer(String CustomerId) {
        CustomerEntity customerEntityToFind = new CustomerEntity();
        customerEntityToFind.setCustomerId(CustomerId);

        Optional<CustomerEntity> retrievedCustomerEntity =
                customerRepository.findOne(Example.of(customerEntityToFind, ExampleMatcher.matchingAll()));

        if (retrievedCustomerEntity.isEmpty()) return null;

        Customer customer = mapper.map(retrievedCustomerEntity.get(), Customer.class);

        return customer;
    }

    /*

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
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
