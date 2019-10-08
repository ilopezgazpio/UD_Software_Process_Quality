package server;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import serialization.Message;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class ServletContainer
{

    @POST
    @Path("/postRequest")
    public Response postRequest(Message message)
    {
	System.out.println("I'm the ServletContainer, postRequest method");
	System.out.println("Received a post request, content of message: " + message.getContent());
	Message response = new Message("Managed POST request");
	return Response.ok(response).build();
    }

    @GET
    @Path("/getRequest")
    public Response getRequest()
    {
	System.out.println("I'm the ServletContainer, getRequest method");
	System.out.println("Managing get request");
	Message response = new Message("Managed get request");
	return Response.ok(response).build();
    }

}
