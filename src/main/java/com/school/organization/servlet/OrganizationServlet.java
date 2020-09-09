package com.school.organization.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.organization.bean.OrganizationBeanI;
import com.school.organization.model.Organization;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/organization")
public class OrganizationServlet extends HttpServlet {

    @EJB
    private OrganizationBeanI organizationBean;

    @Inject
    private Organization organization;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        if (organization != null && StringUtils.isNotBlank(organization.getAction())
                && organization.getAction().equalsIgnoreCase("load") && organization.getId() != 0)
            resp.getWriter().print(mapper.writeValueAsString(organizationBean.load(organization.getId())));
        else
            resp.getWriter().print(mapper.writeValueAsString(organizationBean.list()));

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            BeanUtils.populate(organization, request.getParameterMap());
            response.getWriter().print(organizationBean.add(organization));

        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }

    }

    protected  void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            BeanUtils.populate(organization, request.getParameterMap());

            response.getWriter().print(organizationBean.delete(organization.getId()));

        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }

    }

}
