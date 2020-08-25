package com.school.utilities;

import java.io.Serializable;

public class User implements Serializable {

    private String name;

    private String address;

    private String email;

    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String showAge(){
        if (name != null && name.equalsIgnoreCase("mike"))
            return "<br> " + name + " from " + address + " is " + 34 + " Years OLD!!";

        else
            return "";
    }
}
