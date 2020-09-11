package com.school.organization.model;

import javax.persistence.*;

@Entity
@Table(name = "skul_departments")
public class Department extends BaseEntity {

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
