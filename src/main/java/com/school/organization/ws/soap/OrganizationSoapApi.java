package com.school.organization.ws.soap;

import com.school.organization.bean.OrganizationBeanI;
import com.school.organization.model.skul.Organization;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class OrganizationSoapApi {

    @EJB
    private OrganizationBeanI organizationBean;

    @WebMethod
    public List<Organization> helloWorld(@WebParam String name){
        return organizationBean.list();
    }

}
