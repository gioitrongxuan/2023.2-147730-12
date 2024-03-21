
public class MessageModel {
    private String message;
    
    public void setMessage(String message) {
        this.message = "Hello " +message+" \nYou are the most beautiful person in the world";
    }

    public String getMessage() {
        return message;
    }
}