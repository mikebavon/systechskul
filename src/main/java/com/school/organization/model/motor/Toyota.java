package com.school.organization.model.motor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Toyota")
public class Toyota extends Car{

    @Column(name = "japan_town")
    private String japanTown;

    public String getJapanTown() {
        return japanTown;
    }

    public void setJapanTown(String japanTown) {
        this.japanTown = japanTown;
    }

    public String toyotaDetails(){
        return getName() + " " + getBodyType() + " " + getJapanTown();
    }
}
