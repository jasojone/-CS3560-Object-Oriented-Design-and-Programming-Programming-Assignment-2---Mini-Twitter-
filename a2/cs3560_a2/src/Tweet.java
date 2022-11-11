// 

public class Tweet implements Message {
    private String id;
    private String tweet;
    private String timestamp;
    private String author;
    
    public Tweet(String id, String tweet, String timestamp, String author) {
        this.id = id;
        this.tweet = tweet;
        this.timestamp = timestamp;
        this.author = author;
    }
    
    public String getID() {
        return id;
    }
    
    public String getTweet() {
        return tweet;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setID(String id) {
        this.id = id;
    }
    
    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
}
    