package com.school.organization.model.motor;

import com.school.organization.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "cars")
//@DiscriminatorValue("N_A")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Car extends BaseEntity {

    @Column
    private String name;

    @Column(name = "body_type")
    private String bodyType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String carDetails(){
        return getName() + " " + getBodyType();
    }
}
