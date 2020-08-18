package com.school.utilities.listeners;

import com.school.utilities.DbConnection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebListener
public class DatabaseBootstrap implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        DbConnection dbConnection = new DbConnection("jdbc:mysql://localhost:3306/","root",
                "Okello3477#*");

        System.out.println("INFO: Creating database if it does not exist....");

        Statement statement = null;
        Statement statement2 = null;

        try {
            statement = dbConnection.connect().createStatement();
            statement.execute("CREATE DATABASE IF NOT EXISTS systech_skul");

            System.out.println("INFO: db created or updated successfully...");

            System.out.println("INFO: Connection to database just created or existing");
            DbConnection dbConnection2 = new DbConnection("jdbc:mysql://localhost:3306/systech_skul","root",
                    "Okello3477#*");
            statement2 = dbConnection2.connect().createStatement();


            System.out.println("INFO: Creating tables");
            statement2.execute("create table if not exists organization(name varchar(255), address varchar(255))");

            sce.getServletContext().setAttribute("dbConnection", dbConnection2.connect());


        }catch (SQLException sqEx){
            sqEx.printStackTrace();
        }finally {
            try {
                if (statement != null)
                    statement.close();

                if (statement2 != null)
                    statement2.close();

            }catch (SQLException sqlEx2){
                sqlEx2.printStackTrace();
            }
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        Connection connection = (Connection) sce.getServletContext().getAttribute("dbConnection");

        if (connection != null){
            try{
                connection.close();
            }catch (SQLException sqlEx){
                sqlEx.printStackTrace();
            }
        }

    }
}
