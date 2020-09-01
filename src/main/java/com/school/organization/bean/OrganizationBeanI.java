package com.school.organization.bean;

import com.school.organization.model.Organization;

import java.sql.Connection;
import java.util.List;

public interface OrganizationBeanI {

    String add(Connection connection, Organization organization);

    List<Organization> list(Connection connection);
}
