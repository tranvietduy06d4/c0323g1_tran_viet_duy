package com.example.customer_list_demo;

import java.util.Date;

public class Customer {
    private String name;
    private String birthDay;
    private String address;
    private String avatar;

    public Customer() {
    }

    public Customer(String name, String birthDay, String address, String avatar) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}



