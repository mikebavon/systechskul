package com.school.organization.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.organization.annotation.NotSaveToDb;
import com.school.organization.annotation.SaveToDb;
import com.school.organization.bean.OrganizationBeanI;
import com.school.organization.model.Organization;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/organization")
public class OrganizationServlet extends HttpServlet {

    @Inject @SaveToDb
    private OrganizationBeanI organizationBean;

    @Inject
    private Organization organization;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");
        resp.setContentType("text/plain");

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(organizationBean.list(dbConnection)));

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");

        try {
            BeanUtils.populate (organization, request.getParameterMap());

        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());

        }

        response.getWriter().print(organizationBean.add(dbConnection, organization));

    }

}
