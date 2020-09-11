package com.school.organization.model.hospital;

import com.school.organization.model.BaseEntity;
import com.school.organization.model.skul.BioData;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor extends BaseEntity {

    @Embedded
    private BioData bioData;

    @Column(name = "practice_id")
    private String practiceId;

    public BioData getBioData() {
        return bioData;
    }

    public void setBioData(BioData bioData) {
        this.bioData = bioData;
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId;
    }
}
