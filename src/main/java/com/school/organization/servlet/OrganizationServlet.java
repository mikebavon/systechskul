package com.school.organization.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/organization")
public class OrganizationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext scx = getServletContext();
        Connection dbConnection = (Connection) scx.getAttribute("dbConnection");

        resp.setContentType("text/html");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table width='100%'><tr><th>NAME</th><th>ADDRESS</th><tr>");
        try {
            PreparedStatement statement = dbConnection.prepareStatement("SELECT * FROM organization");
            statement.execute();
            ResultSet result = statement.getResultSet();

            while (result.next()){
                stringBuilder.append("<tr><th>" + result.getString("name")
                    + "</th><th>" + result.getString("address") + "</th><tr>");
            }

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        stringBuilder.append("</table>");


        PrintWriter printWriter = resp.getWriter();
        printWriter.println(stringBuilder);

    }


}
