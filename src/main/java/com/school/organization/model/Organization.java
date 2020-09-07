package com.school.organization.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "skul_organizations")
public class Organization implements Serializable {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String town;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return town == null? "N/a" :town.toUpperCase();
    }

    public void setTown(String town) {
        this.town = town;
    }
}
