package org.example.api.services;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
public class ApiTest {

    @GET
    @Path("/test")
    public Response test(){
        return Response.ok("API WORKS!!").build();
    }
}
