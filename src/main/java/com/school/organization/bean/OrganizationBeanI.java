package com.school.organization.bean;

import com.school.organization.model.skul.Organization;

import java.util.List;

public interface OrganizationBeanI {

    String add(Organization organization) throws Exception;

    Organization load(int organizationId);

    String delete(int organizationId) throws Exception;

    List<Organization> list();
}
