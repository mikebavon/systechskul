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
public class OrganizationBean implements OrganizationBeanI{

    @PersistenceContext
    private EntityManager em;

    public String add(Organization organization) throws Exception{
        if (organization == null || organization.getName() == null)
            throw new Exception("Invalid organization details!!");

        for (int idx = 0; idx<20; idx++) {
            Faculty faculty = new Faculty();
            faculty.setName("Faculty " + idx);
            organization.addFaculty(faculty);
        }

        em.merge(organization);

        return "OK";
    }

    public List<Organization> list(){
        return em.createQuery("FROM Organization o").getResultList();
    }

}
