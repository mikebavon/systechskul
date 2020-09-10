package com.school.organization.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contact {

    @Column(name = "phone_no")
    private String phoneNo;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String town;

    @Column
    private String country;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town == null? "N/a" :town.toUpperCase();
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
