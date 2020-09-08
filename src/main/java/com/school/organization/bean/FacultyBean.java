package com.school.organization.bean;

import com.school.organization.model.Faculty;
import com.school.organization.model.Organization;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
public class FacultyBean {

    @PersistenceContext
    private EntityManager em;

    public String add(Faculty faculty){
        faculty.setOrganization(new Organization());
        faculty.getOrganization().setName(faculty.getName());
        faculty.getOrganization().setAddress("Unknown");

        em.merge(faculty);

        return "OK";
    }

    public List<Organization> list(){
        return em.createQuery("FROM Faculty f").getResultList();
    }

}
