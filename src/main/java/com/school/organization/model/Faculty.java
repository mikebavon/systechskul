package com.school.organization.model;

import javax.persistence.*;

@Entity
@Table(name = "skul_faculties")
public class Faculty {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Organization organization;

    @Transient
    private int organizationId;

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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}
