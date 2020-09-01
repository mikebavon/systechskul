package com.school.organization.bean;

import com.school.organization.annotation.SaveToDb;
import com.school.organization.model.Organization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SaveToDb
public class OrganizationBean implements OrganizationBeanI{

    public String add(Connection connection, Organization organization){
        if (connection == null)
            return "FAILED: NO CONNECTION";

        if (organization == null)
            return "FAILED: INVALID ORGANIZATION DETAILS";

        try {
            PreparedStatement statement = connection.prepareStatement("insert into organization(name,address) values(?,?)");
            statement.setString(1, organization.getName()==null?null: organization.getName().toUpperCase());
            statement.setString(2, organization.getAddress()==null?null: organization.getAddress().toUpperCase());
            statement.executeUpdate();

        }catch (SQLException sqlEx){
            return sqlEx.getCause().getMessage();

        }

        return "OK";
    }

    public List<Organization> list(Connection connection){
        List<Organization> organizations = new ArrayList<Organization>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM organization");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()){
                Organization organization = new Organization();
                organization.setName(result.getString("name"));
                organization.setAddress(result.getString("address"));

                organizations.add(organization);
            }

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        return organizations;
    }
}
