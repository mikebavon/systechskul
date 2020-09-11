package com.school.organization.model;

import javax.persistence.*;

@Entity
@Table(name = "skul_lecturers")
public class Lecturer extends BaseEntity{

    @Embedded
    private BioData bioData;

    @Column(name = "job_number")
    private String jobNumber;

    @Embedded
    private Contact contact;

    public BioData getBioData() {
        return bioData;
    }

    public void setBioData(BioData bioData) {
        this.bioData = bioData;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
