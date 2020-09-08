package com.school.organization.bean;

import com.school.organization.model.Organization;

import java.util.List;

public interface OrganizationBeanI {

    String add(Organization organization) throws Exception;

    String delete(int organizationId) throws Exception;

    List<Organization> list();
}
