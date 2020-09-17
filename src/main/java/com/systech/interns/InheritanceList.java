package com.systech.interns;

import com.school.organization.bean.InheritanceTest;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InheritanceList implements ServletContextListener {

    @EJB
    private InheritanceTest inheritanceTest;

    public void contextInitialized(ServletContextEvent sce){
        //inheritanceTest.addSomeCars();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        inheritanceTest.listToyata("Land",0, 2);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        /*inheritanceTest.listAudi();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        inheritanceTest.listCars();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();*/



    }
}
