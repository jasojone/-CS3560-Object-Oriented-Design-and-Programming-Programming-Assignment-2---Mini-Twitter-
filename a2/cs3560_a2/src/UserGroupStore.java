// this class will be used to store the user and group information
// in the system

import java.util.*;


public class UserGroupStore {
    private List<User> users;
    private List<Group> groups;

    public UserGroupStore() {
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
     * @param userID
     * @return User
     */
    public User getUser(String userID) {
        for (User user : this.users) {
            if (user.getID().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    /** 
     * @param groupID
     * @return Group
     */
    public Group getGroup(String groupID) {
        for (Group group : this.groups) {
            if (group.getID().equals(groupID)) {
                return group;
            }
        }
        return null;
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
}
    // a method that searches the user list for a user with the given ID
    // and returns true if found, otherwise returns null
    