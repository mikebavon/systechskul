package com.school.organization.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.organization.bean.FacultyBean;
import com.school.organization.model.Faculty;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/faculty")
public class FacultyServlet  extends HttpServlet {

    @EJB
    private FacultyBean facultyBean;

    @Inject
    private Faculty faculty;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().print(mapper.writeValueAsString(facultyBean.list()));

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            BeanUtils.populate(faculty, request.getParameterMap());
        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }

        response.getWriter().print(facultyBean.add(faculty));

    }

}