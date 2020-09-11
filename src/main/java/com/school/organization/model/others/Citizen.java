package com.school.organization.model.others;

import com.school.organization.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "citizens")
public class Citizen extends BaseEntity {

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private IdCard idCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }
}
