package com.school.organization.model.motor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Audi")
public class Audi extends Car{

    @Column(name = "german_town")
    private String germanTown;

    public String getGermanTown() {
        return germanTown;
    }

    public void setGermanTown(String germanTown) {
        this.germanTown = germanTown;
    }

    public String audiDetails(){
        return getName() + " " + getBodyType() + " " + getGermanTown();
    }
}
