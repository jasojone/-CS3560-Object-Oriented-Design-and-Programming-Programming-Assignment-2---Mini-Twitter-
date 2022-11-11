import java.util.List;
// parent class for User and Group classes 
// The Composite Pattern has four participants:

//@UserComponent.java
// 1. Component - declares the interface for objects in the composition and for accessing and managing its child components.
// 2. Leaf - represents leaf objects in the composition. A leaf has no children.
// 3. Composite - defines behavior for components having children. Stores child components.
// 4. Client - manipulates the objects in the composition through the Component interface.

import javax.swing.tree.DefaultMutableTreeNode;


public class UserComponent extends DefaultMutableTreeNode {
    
    /** 
     * @return String
     * {@summary} returns the ID of the user or group
     * 
     */
    public String getID() {
        return null;
    }
    
    
    /** 
     * @return List<User>
     */
    public List<User> getUsers() {
        return null;
    }
    
    
    /** 
     * @return List<Group>
     */
    public List<Group> getGroups() {
        return null;
    }
    
    
    /** 
     * @return List<String>
     */
    public List<String> getFollowers() {
        return null;
    }
    
    
    /** 
     * @return List<Tweet>
     */
    public List<Tweet> getNewsFeed() {
        return null;
    }

    
    /** 
     * @return List<UserComponent>
     */
    public List<UserComponent> getComponents() {
        return null;
    }

    
    /** 
     * @param followerID
     */
    public void addFollower(String followerID) {
    }

    
    /** 
     * @param message
     */
    public void addMessage(Tweet message) {
    }

    
    /** 
     * @param component
     */
    public void addComponent(UserComponent component) {
    }
    
    /** 
     * @return String
     */
    // add tostring method
    public String toString() {
        return null;
    }

}
