package com.school.organization.model.hospital;

import com.school.organization.model.BaseEntity;
import com.school.organization.model.skul.BioData;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {

    @Embedded
    private BioData bioData;

    public BioData getBioData() {
        return bioData;
    }

    public void setBioData(BioData bioData) {
        this.bioData = bioData;
    }
}
