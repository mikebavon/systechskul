package com.school.organization.bean;

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

    public String add(Organization organization){
        em.merge(organization);

        return "OK";
    }

    public List<Organization> list(){
        return em.createQuery("FROM Organization o").getResultList();
    }

}
