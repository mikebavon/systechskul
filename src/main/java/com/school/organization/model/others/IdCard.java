package com.school.organization.model.others;

import com.school.organization.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "id_cards")
public class IdCard extends BaseEntity {

    @Column(name = "id_no")
    private String idNo;

    @Column(name = "serial_no")
    private String serialNo;

    @OneToOne(mappedBy = "idCard")
    private Citizen citizen;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

}
