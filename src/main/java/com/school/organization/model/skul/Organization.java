package com.school.organization.model.skul;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.organization.model.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skul_organizations")
public class Organization extends BaseEntity {

    @Column
    private String name;

    @Embedded
    private Contact contact;

    @Transient
    private String action;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Faculty> faculties = new ArrayList<Faculty>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonIgnore
    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void addFaculty(Faculty faculty){
        faculty.setOrganization(this);
        this.faculties.add(faculty);
    }

    @JsonIgnore
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
