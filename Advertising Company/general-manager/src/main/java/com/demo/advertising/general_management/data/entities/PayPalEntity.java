package com.demo.advertising.general_management.data.entities;

import javax.persistence.Embeddable;

@Embeddable
public class PayPalEntity {

    private String username;
    private String password;

    public PayPalEntity(){

    }

    public PayPalEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
