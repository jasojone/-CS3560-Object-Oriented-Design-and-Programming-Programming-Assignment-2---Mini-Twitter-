import java.util.List;
// parent class for User and Group classes 
// The Composite Pattern has four participants:

// Component – Component declares the interface for objects in the composition and for accessing and managing its child components. 
// It also implements default behavior for the interface common to all classes as appropriate.
// Leaf – Leaf defines behavior for primitive objects in the composition. It represents leaf objects in the composition.
// Composite – Composite stores child components and implements child related operations in the component interface.
// Client – Client manipulates the objects in the composition through the component interface.


import javax.swing.tree.DefaultMutableTreeNode;


public class UserComponent extends DefaultMutableTreeNode {
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

    public void addComponent(UserComponent component) {
    }
    // add tostring method
    public String toString() {
        return null;
    }

}
