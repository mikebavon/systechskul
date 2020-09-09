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

        faculty.setOrganization(em.find(Organization.class, faculty.getOrganizationId()));
        em.merge(faculty);

        return "OK";
    }

    public String delete(int facultyId) throws Exception{
        if (facultyId == 0)
            throw new Exception("Invalid faculty details!!");

        em.remove(em.find(Faculty.class, facultyId));

        return "OK";
    }

    public List<Faculty> list(){
        return em.createQuery("FROM Faculty f").getResultList();
    }

}
