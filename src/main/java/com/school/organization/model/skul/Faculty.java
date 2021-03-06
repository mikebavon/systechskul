package com.school.organization.model.skul;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.organization.model.BaseEntity;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@Table(name = "skul_faculties")
public class Faculty extends BaseEntity {

    @Column
    private String name;

    @ManyToOne
    private Organization organization;

    @Formula("(select org.name from skul_organizations org where org.id=organization_id)")
    private String organizationName;

    @Formula("coalesce(organization_id,0)")
    private int organizationId;

    @Transient
    private String action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
