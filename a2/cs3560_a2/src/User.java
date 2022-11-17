
import java.util.ArrayList;
import java.util.List;


public class User extends SysEntry implements Observer {
    private List<SysEntry> followers;
    private List<SysEntry> followings;
    private List<Tweet> newsFeed;

    public User(String userID) {
        super(userID);
        this.followers = new ArrayList<SysEntry>();
        this.followings = new ArrayList<SysEntry>();
        this.newsFeed = new ArrayList<Tweet>();
    }

    /** 
     * @param followerID
     */
    public void addFollower(SysEntry followerID) {
        this.followers.add(followerID);
    }

    /** 
     * @param followingID
     */
    public void addFollowing(SysEntry followingID) {
        this.followings.add(followingID);
    }

    /** 
     * @param tweet
     */
    public void addTweet(Tweet tweet) {
        this.newsFeed.add(tweet);
    }

    /** 
     * @return List<Tweet>
     */
    public List<Tweet> getNewsFeed() {
        return this.newsFeed;
    }

    /** 
     * @return List<String>
     */
    public List<SysEntry> getFollowers() {
        return this.followers;
    }

    /** 
     * @return List<String>
     */
    public List<SysEntry> getFollowings() {
        return this.followings;
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        
    }

    public boolean containsUser(String userName) {
        return false;
    }

    @Override
    public void update(String event) {
        
    }
    // a method to see if the user exists in the list of users
    // public boolean containsUser(List<User> users, String userName) {
    //     for (User user : users) {
    //         if (user.getID().equals(userName)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }


}
    
    