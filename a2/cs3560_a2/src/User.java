//composite class that implements the UserComponent interface
//user class that extends the user class in the adminUI class 
// A user has a unique ID; 
// 2) a list of user IDs that are following this user (followers); 
// 3) a list of user IDs being followed by this user (followings); 
// 4) a news feed list containing a list of Twitter messages.
//
// The user class has the following methods:
// 1) a constructor that takes a user ID as a parameter;
// 2) a method to add a follower;
// 3) a method to add a following;
// 4) a method to add a message to the news feed;
// 5) a method to get the news feed.
//
// The user class also has the following methods that are inherited from the user class:
// 1) a method to get the ID;
// 2) a method to get the list of followers;
// 3) a method to get the list of followings.
//

import java.util.ArrayList;
import java.util.List;


public class User extends UserComponent {
    
    private String userID;
    private List<String> followers;
    private List<String> followings;
    private List<Tweet> newsFeed;
    
    public User(String userID) {
        this.userID = userID;
        this.followers = new ArrayList<String>();
        this.followings = new ArrayList<String>();
        this.newsFeed = new ArrayList<Tweet>();
    }
    
    
    /** 
     * @param followerID
     */
    public void addFollower(String followerID) {
        this.followers.add(followerID);
    }
    
    
    /** 
     * @param followingID
     */
    public void addFollowing(String followingID) {
        this.followings.add(followingID);
    }
    
    
    /** 
     * @param message
     */
    public void addMessage(Tweet message) {
        this.newsFeed.add(message);
    }
    
    
    /** 
     * @return List<Tweet>
     */
    public List<Tweet> getNewsFeed() {
        return this.newsFeed;
    }
    
    
    /** 
     * @return String
     */
    public String getID() {
        return this.userID;
    }
    
    
    /** 
     * @return List<String>
     */
    public List<String> getFollowers() {
        return this.followers;
    }
    
    
    /** 
     * @return List<String>
     */
    public List<String> getFollowings() {
        return this.followings;
    }

    
    /** 
     * @return char[]
     */
    public char[] getName() {
        return null;
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return this.userID;
    }
}
