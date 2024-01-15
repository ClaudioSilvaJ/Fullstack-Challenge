package org.example.api.services;

import org.example.APIServer;
import org.example.dtos.SendDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static org.example.functions.AccumulateParticipation.verifyParticipation;

@Path( "/")
public class MainServices extends APIServer {

    @POST
    @Path("/register")
    @Consumes("application/json; charset=UTF-8")
    public Response register(SendDTO userSendDTO){
        try {
            datastore.save(verifyParticipation(userSendDTO));
            return Response.created(null).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/get")
    @Produces("application/json; charset=UTF-8")
    public Response get(){
        try {
            return Response.ok(datastore.createQuery(SendDTO.class).asList()).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
