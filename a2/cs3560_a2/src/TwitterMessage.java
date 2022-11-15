
public class TwitterMessage {
    private String message;
    private String user;
    
    public TwitterMessage(String user, String message) {
        this.user = user;
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public String getUser() {
        return user;
    }

}
