package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import serialization.Message;

public class RestClient
{

    private Client client;
    private WebTarget webTarget;


    public RestClient(String hostname, String port)
    {
	client = ClientBuilder.newClient();
	webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));
    }

    public void makeGetRequest() throws Exception
    {
	WebTarget getRequestController = this.webTarget.path("resource/getRequest");
	Invocation.Builder invocationBuilder = getRequestController.request(MediaType.APPLICATION_JSON);
	Response response = invocationBuilder.get();

	if (response.getStatus() == Status.OK.getStatusCode())
	    {
		Message responseMessage= response.readEntity(Message.class);
		System.out.println("I am the client, I have made a simple GET request with no parameters, and I have received a Message class response");
		System.out.println("This is the content of the message: " + responseMessage.getContent());
	    }
	else
	    {
		System.out.println("I am the client, I have made a simple GET request with no parameters, and I have received a BadAss error");
		throw new Exception("BadAss error");
	    }
    }

    public void makePostRequest(String content) throws Exception
    {
	WebTarget postRequestController = webTarget.path("resource/postRequest");
	Invocation.Builder invocationBuilder = postRequestController.request(MediaType.APPLICATION_JSON);

	Message messageFromClient = new Message(content);

	Response response = invocationBuilder.post(Entity.entity(messageFromClient, MediaType.APPLICATION_JSON));
	if (response.getStatus() != Status.OK.getStatusCode())
	    {
		System.out.println("I am the client, I have made a POST complex request with parameters, and I have received a BadAss error");
		throw new Exception("BadAss error");
	    }
	else
	    {
		Message responseMessage= response.readEntity(Message.class);
		System.out.println("I am the client, I have made a POST complex request with parameters, and I have received a Message class response");
		System.out.println("This is the content of the message" + responseMessage.getContent());
	    }
    }

    public static void main(String[] args)
    {
	String hostname = args[0];
	String port = args[1];

	RestClient c1 = new RestClient(hostname, port);
	RestClient c2 = new RestClient(hostname, port);
	RestClient c3 = new RestClient(hostname, port);
	RestClient c4 = new RestClient(hostname, port);

	try
	    {
		c1.makeGetRequest();
		c1.makePostRequest("This is a client super complex message to send to server");

	    }
	catch (Exception e)
	    {
		System.out.println("Catched exception: " + e.getMessage());
	    }
    }
}
