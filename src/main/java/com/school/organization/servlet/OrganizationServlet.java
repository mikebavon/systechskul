package com.school.organization.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.organization.model.Organization;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/organization")
public class OrganizationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");
        resp.setContentType("text/plain");

        List<Organization> organizations = new ArrayList<Organization>();

        try {
            PreparedStatement statement = dbConnection.prepareStatement("SELECT * FROM organization");
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

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(organizations));

    }


}
