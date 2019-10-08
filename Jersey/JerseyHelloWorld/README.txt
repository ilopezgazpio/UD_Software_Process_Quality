EXECUTION STEPS
---------------
1. mvn compile

In three separate cmd windows, run:

2. mvn jetty:run
3. mvn exec:java -Pclient
4. mvn exec:java -Pserver


What is Jersey ?
-----------------
If your're thinking on clothes, it seems you need to start attending lessons...

Jersey is the open source reference implementation of Java JAX-RS specification.
This specification provides a Java library to easily create RESTful web services.


What is a RESTful web service ?
--------------------------------
REST (Representational State Transfer) is an architectural style which is based on web-standards and the HTTP protocol.

REST is popular due to its simplicity and the fact that it builds upon existing systems and features of the internet's Hypertext Transfer Protocol (HTTP) in order to achieve its objectives, as opposed to creating new standards, frameworks and technologies.


What are these objectives ?
----------------------------
To communicate distinct Java artifacts as microservices.


What are microservices ?
-------------------------
The Microservice paradigm is a form of service-oriented architecture style (one of the most important skills for Java developers) wherein applications are built as a collection of different smaller services rather than one whole app

Really, I'm getting tired... so what the hell is Jersey ?
---------------------------------------------------------
A technology we will be using in class to communicate clients and servers, using all the goodness of features described above ;)


Important details to take into account in the code
--------------------------------------------------

1. Note the hostname and port definition in the pom
2. Note how 3 execution calls will be made
2.1. Call 1 runs the jetty web server with the remote resource
2.2. Call 2 runs a simple client
2.3. Call 3 runs a server, such an appServer (which is really a complex client pulling the remote resource)
3. Note how running the jetty web server will imply loading the web.xml file, which defines the Servlet of the application (the container).
3.1. Note that the ServletContainer Java class defines the accesible URIs for the REST api. (i.e. Configuration for the controller)
3.2. Note that this class can be as complex as required, and could possibly implement the Façade design pattern, with AppServices defined in it.
4. Note that client.RestClient implements the functionality for a RESTful simple client performing GET and POST request to the target resource
4.1. We can easily debug the remote resource with the curl tool
```
curl -v 127.0.0.1:8080/rest/resource/getRequest
```
4.2. we can also debug POST method
```
curl -X POST -H 'Content-Type:application/json' http://localhost:8080/rest/resource/postRequest -d '{"content":"Hello World message sended through curl"}'
```
5. Note that server.RestServer implements the functionality of a server like an AppService that needs to pull the remote resource to perfom its functionality
5.1. This happens because in RESTful microservices we always have stateless connections (HTTP), and it is the resource that needs the information the one with the responsibility to call the remote resource


















