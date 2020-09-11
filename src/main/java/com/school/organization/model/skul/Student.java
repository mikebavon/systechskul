package com.school.organization.model.skul;

import com.school.organization.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "skul_students")
public class Student extends BaseEntity {

    @Embedded
    private BioData bioData;

    @Column(name = "registration_no")
    private String registrationNo;

    @Embedded
    private Contact contact;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public BioData getBioData() {
        return bioData;
    }

    public void setBioData(BioData bioData) {
        this.bioData = bioData;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
