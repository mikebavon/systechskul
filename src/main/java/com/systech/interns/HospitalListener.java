package com.systech.interns;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class HospitalListener implements ServletContextListener {

    @EJB
    private HospitalBean hospitalBean;

    public void contextInitialized(ServletContextEvent sce){
        hospitalBean.populateCitizens();

    }
}
