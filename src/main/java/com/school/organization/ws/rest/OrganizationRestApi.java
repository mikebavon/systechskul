package com.school.organization.ws.rest;

import com.school.organization.bean.OrganizationBeanI;
import com.school.organization.model.skul.Organization;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/organization")
public class OrganizationRestApi {

    @EJB
    private OrganizationBeanI organizationBean;

    @GET
    @Path("/list/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam(value = "name") String name){

        System.out.println("Query param name: " + name);
        return Response.status(200).entity(organizationBean.list()).build();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(Organization organization){
        try {
            organizationBean.add(organization);
        }catch (Exception ex){
            return "{\"FAILURE\":\"" + ex.getMessage() + "\"}";
        }

        return "{\"SUCCESS\":\"OK\"}";
    }


}
