package com.demo.advertising.general_management.services;

import com.demo.advertising.general_management.data.entities.CardEntity;
import com.demo.advertising.general_management.data.entities.CustomerEntity;
import com.demo.advertising.general_management.data.repositories.CustomerRepository;
import com.demo.advertising.general_management.services.models.Customer;
import com.demo.advertising.general_management.services.models.Payment.PaymentByCardStrategy;
import com.demo.advertising.general_management.services.models.Payment.PaymentByPayPalStrategy;
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

        CustomerEntity customerEntity;
        boolean card = false;

        customerEntity = mapper.map(customer, CustomerEntity.class);

        //check if customer id already exists

        Optional<CustomerEntity> customerOptional = customerRepository
                .findCustomerByCustomerId(customerEntity.getCustomerId());

        if(customerOptional.isPresent()){
            throw new IllegalStateException("Customer ID already exists!");
        }

        //check required customer fields are filled in

        if(customer.getCustomerId().equals("string")){
            throw new IllegalStateException("Customer ID is required!");
        } else if(customer.getName().equals("string")){
            throw new IllegalStateException("Name is required!");
        } else if(customer.getEmail().equals("string")){
            throw new IllegalStateException("Email is required!");
        } else if(customer.getPhoneNumber().equals("string")){
            throw new IllegalStateException("Phone number is required!");
        }

        //a customer has to either input card details or paypal details
        //card details and payment details both empty

        if(
                (customer.getCardDetails().getCardNumber().equals("string")
                        && customer.getCardDetails().getExpiryDate().equals("string")
                        && customer.getCardDetails().getCvv().equals("string")
                ) &&
                        (customer.getPaypalDetails().getUsername().equals("string")
                                && customer.getPaypalDetails().getPassword().equals("string")
                        )
        )
        {
            throw new IllegalStateException("Please fill in either card details or paypal details!");
        }


        //if first field of Card is filled in then the other fields are also expected to be filled in
        if(!customer.getCardDetails().getCardNumber().equals("string")){
            if(customer.getCardDetails().getExpiryDate().equals("string")){
                throw new IllegalStateException("Card expiry date is required!");
            } else if(customer.getCardDetails().getCvv().equals("string")){
                throw new IllegalStateException("Card cvv is required!");
            } else if(!customer.getPaypalDetails().getUsername().equals("string")
            || !customer.getPaypalDetails().getPassword().equals("string")){
                throw new IllegalStateException("Choose either card OR paypal!");
            }
        }

        //if first field of PayPal is filled in then the other fields are also expected to be filled in
        if(!customer.getPaypalDetails().getUsername().equals("string")){
            if(customer.getPaypalDetails().getPassword().equals("string")){
                throw new IllegalStateException("Password is required!");
            }
        }

        //if PayPal details are NOT inputted then card is true
        if((customer.getPaypalDetails().getUsername().equals("string")
                && customer.getPaypalDetails().getPassword().equals("string")
        )){
            card = true;
        }

        // subscribe validation

        if(customer.getSubscribe().equals("string")){
            throw new IllegalStateException("Type yes OR no to subscribe!");
        }

        if(customer.getSubscribe().equalsIgnoreCase("yes")){
            customer.setSubscribe("yes");
        } else if(customer.getSubscribe().equalsIgnoreCase("no")){
            customer.setSubscribe("no");
        } else {
            throw new IllegalStateException("Type yes or no to subscribe!");
        }

        if(card){

            // check if cvv is valid
            if (customer.getCardDetails().getCvv().length() != 3) {
                throw new IllegalStateException("Invalid cvv! It must be 3 characters long!");
            }
            customerRepository.save(customerEntity);
        } else {
            customerRepository.save(customerEntity);
        }
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
    public void updateCustomer(String customerId, String name, String email, String phoneNumber, CardEntity card) {

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

        if(phoneNumber != null && !Objects.equals(customer.getPhoneNumber(), phoneNumber)){
            customer.setPhoneNumber(phoneNumber);
        }

        if(card.getCardNumber() != null && !Objects.equals(customer.getCardDetails().getCardNumber(), card.getCardNumber())){
            customer.getCardDetails().setCardNumber(card.getCardNumber());
            if(card.getExpiryDate() != null && !Objects.equals(customer.getCardDetails().getExpiryDate(), card.getExpiryDate())){
                customer.getCardDetails().setExpiryDate(card.getExpiryDate());
                if(card.getCvv() != null && !Objects.equals(customer.getCardDetails().getCvv(), card.getCvv())){
                    customer.getCardDetails().setCvv(card.getCvv());
                }
            }
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
