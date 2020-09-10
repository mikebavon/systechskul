package com.school.organization.model;

import javax.persistence.*;

@Entity
@Table(name = "skul_lecturers")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private BioData bioData;

    @Column(name = "job_number")
    private String jobNumber;

    @Embedded
    private Contact contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
