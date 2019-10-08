package serialization;

public class Message
{

    private String content;

    public Message()
    {
	this.content = "Empty message";
    }

    public Message(String content)
    {
	this.content = content;
    }


    public String getContent()
    {
	return this.content;
    }
}
