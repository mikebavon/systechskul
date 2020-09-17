package com.school.organization.model.motor;

import javax.persistence.*;


@NamedQueries({
    @NamedQuery(name = Toyota.NQ_TOYOTA_ALL, query = "SELECT t from Toyota t"),
    @NamedQuery(name = Toyota.NQ_TOYOTA_SEARCH_BY_NAME, query = "SELECT t from Toyota t WHERE t.name like :searchKey")
})
@Entity
@DiscriminatorValue("Toyota")
public class Toyota extends Car{

    public static final String NQ_TOYOTA_ALL = "Toyota.All";
    public static final String NQ_TOYOTA_SEARCH_BY_NAME = "Toyota.SearchByName";

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
