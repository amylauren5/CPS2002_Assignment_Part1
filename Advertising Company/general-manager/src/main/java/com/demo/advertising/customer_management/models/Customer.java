package com.demo.advertising.customer_management.models;

import java.time.LocalDate;

public class Customer {

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    private String paymentDetails;

    public Customer() {
    }

    public Customer(Long id,
                    String name,
                    String email,
                    LocalDate dob,
                    Integer age,
                    String paymentDetails) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.paymentDetails = paymentDetails;
    }

    public Customer(String name,
                    String email,
                    LocalDate dob,
                    Integer age,
                    String paymentDetails) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.paymentDetails = paymentDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
