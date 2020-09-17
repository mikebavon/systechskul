package com.school.organization.ws.rest;

import com.school.organization.bean.OrganizationBeanI;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/organization")
public class OrganizationRestApi {

    @EJB
    private OrganizationBeanI organizationBean;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return Response.status(200).entity(organizationBean.list()).build();
    }


}
