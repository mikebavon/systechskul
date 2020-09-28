package com.systech.interns;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HelloListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Creating database connection for whole applicatoin............");

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("dbconnection", "database will be connected here!!!!");


    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("closing database connection for whole applicatoin............");

    }

}
