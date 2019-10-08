package es.deusto.server.data;

public class DirectedMessage {

    private User user;
    private String message;

    public DirectedMessage() {

    }
    
    public DirectedMessage(String login, String password, String message) {
    	this.user = new User(login, password);
    	this.message = message;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}