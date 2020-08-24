package com.school.organization.model;

public class Organization {

    private String name;

    private String address;

    private String town;

    private String town1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town.toUpperCase();
    }

    public void setTown(String town) {
        this.town = town;
    }
}
