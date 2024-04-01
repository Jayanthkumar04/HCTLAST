package com.jay.hctlast.entity;

public class Cust_FullAddress {

  String name;

  String country;
  String city;
  String addressLine;
  long pin;
  long phone;
  String email;

    public Cust_FullAddress() {
    }

    public Cust_FullAddress(String name, String country, String city, String addressLine, long pin, long phone, String email) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.addressLine = addressLine;
        this.pin = pin;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public long getPin() {
        return pin;
    }

    public void setPin(long pin) {
        this.pin = pin;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
