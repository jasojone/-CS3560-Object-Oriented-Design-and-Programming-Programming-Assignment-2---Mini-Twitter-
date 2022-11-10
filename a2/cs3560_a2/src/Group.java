// a composite class that implements the UserComponent interface
// can have a list of UserComponents


// A user group has an unique ID, which can be used to group users. A user group can
// contain any number of users. The same user can only be included in one group. Of
// course, a user group can contain other user groups recursively. There is always a root
// group called Root to include everything.
//
// The group class has the following methods:
// 1) a constructor that takes a group ID as a parameter;
// 2) a method to add a user;
// 3) a method to add a group;
// 4) a method to get the ID;
// 5) a method to get the list of users;
// 6) a method to get the list of groups.

import java.util.ArrayList;
import java.util.List;

public class Group extends UserComponent {
    
    private String groupID;
    private List<User> users;
    private List<Group> groups;
    
    public Group(String groupID) {
        this.groupID = groupID;
        this.users = new ArrayList<User>();
        this.groups = new ArrayList<Group>();
    }
    
    
    /** 
     * @param user
     */
    public void addUser(User user) {
        this.users.add(user);
    }
    
    
    /** 
     * @param group
     */
    public void addGroup(Group group) {
        this.groups.add(group);
    }
    
    
    /** 
     * @return String
     */
    public String getID() {
        return this.groupID;
    }
    
    
    /** 
     * @return List<User>
     */
    public List<User> getUsers() {
        return this.users;
    }
    
    
    /** 
     * @return List<Group>
     */
    public List<Group> getGroups() {
        return this.groups;
    }

    
    /** 
     * @return List<UserComponent>
     */
    public List<UserComponent> getComponents() {
        return null;
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
    // add tostring method
    public String toString() {
        return groupID;
    }
}
