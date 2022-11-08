import java.util.List;
// parent class for User and Group classes 

public class UserComponent {
    public String getID() {
        return null;
    }
    
    public List<User> getUsers() {
        return null;
    }
    
    public List<Group> getGroups() {
        return null;
    }
    
    public List<String> getFollowers() {
        return null;
    }
    
    public List<String> getFollowings() {
        return null;
    }
    
    public List<TwitterMessage> getNewsFeed() {
        return null;
    }

    public List<UserComponent> getComponents() {
        return null;
    }

    public void addFollower(String followerID) {
    }

    public void addMessage(TwitterMessage message) {
    }

}
