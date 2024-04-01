package com.jay.hctlast.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class Cust_Address {
@Id
    long address_id;
String country;

String city;

String addressLane;

long pin;

Timestamp LastUpdated;

    public Cust_Address() {
    }

    public Cust_Address(Long address_id, String country, String city, String addressLane, Long pin, Timestamp lastUpdated) {
        this.address_id = address_id;
        this.country = country;
        this.city = city;
        this.addressLane = addressLane;
        this.pin = pin;
        LastUpdated = lastUpdated;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLane() {
        return addressLane;
    }

    public void setAddressLane(String addressLane) {
        this.addressLane = addressLane;
    }

    public long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }

    public Timestamp getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        LastUpdated = lastUpdated;
    }



}
