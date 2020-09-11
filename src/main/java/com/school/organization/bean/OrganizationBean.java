package com.school.organization.bean;

import com.school.organization.model.skul.Organization;

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

        em.merge(organization);

        return "OK";
    }

    public Organization load(int organizationId){
        return em.find(Organization.class, organizationId);
    }

    public String delete(int organizationId) throws Exception{
        if (organizationId == 0)
            throw new Exception("Invalid organization details!!");

        em.remove(em.find(Organization.class, organizationId));

        return "OK";
    }

    public List<Organization> list(){
        return em.createQuery("FROM Organization o").getResultList();
    }

}
