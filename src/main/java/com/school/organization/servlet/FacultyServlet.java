package com.school.organization.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.organization.bean.FacultyBean;
import com.school.organization.model.Faculty;
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
import java.util.ArrayList;

@WebServlet("/faculty")
public class FacultyServlet  extends HttpServlet {

    @EJB
    private FacultyBean facultyBean;

    @Inject
    private Faculty faculty;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            BeanUtils.populate(faculty, req.getParameterMap());
            ObjectMapper mapper = new ObjectMapper();

            if (faculty != null && StringUtils.isNotBlank(faculty.getAction())
                    && faculty.getAction().equalsIgnoreCase("load") && faculty.getId() != 0)
                resp.getWriter().print(mapper.writeValueAsString(facultyBean.load(faculty.getId())));
            else
                resp.getWriter().print(mapper.writeValueAsString(facultyBean.list()));

        }catch (Exception ex){
            ex.printStackTrace();
            resp.getWriter().print(new ArrayList<Faculty>());
        }

    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BeanUtils.populate(faculty, request.getParameterMap());
            response.getWriter().print(facultyBean.add(faculty));

        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }

    }

    protected  void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BeanUtils.populate(faculty, request.getParameterMap());
            response.getWriter().print(facultyBean.delete(faculty.getId()));

        }catch (Exception ex){
            System.out.println(ex.getCause().getMessage());
        }

    }

}