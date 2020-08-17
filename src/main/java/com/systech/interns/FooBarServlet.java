package com.systech.interns;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/foobar")
public class FooBarServlet  extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext scx = getServletContext();
        String dbconnection = (String) scx.getAttribute("dbconnection");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(dbconnection);

    }
}
