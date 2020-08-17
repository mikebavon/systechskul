package com.systech.interns;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       ServletContext scx = getServletContext();

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String city = req.getParameter("city");

        Integer ageInt = new Integer(age);

        StringBuilder msg = new StringBuilder();

        msg.append("Hi " + name + ", from " + city + ". ");

        if (ageInt > 20)
            msg.append("You should be having a girlfriend");
        else
            msg.append("No girlfriend allowed!!!!!");

        msg.append("...." + (String) scx.getAttribute("dbconnection"));

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(msg.toString());

    }

   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();

        printWriter.println("This is our first servlet");

    }
}


