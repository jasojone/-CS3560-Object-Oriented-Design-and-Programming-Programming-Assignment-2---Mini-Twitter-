import java.util.ArrayList;
import java.util.List;

/**
 * Group
 */
public class Group extends SysEntry {
    private List<SysEntry> users;
    private List<SysEntry> groups;

    public Group(String groupID) {
        super(groupID);
        this.users = new ArrayList<SysEntry>();
        this.groups = new ArrayList<SysEntry>();
    }

    /** 
     * @param userID
     */
    public void addUser(User userID) {
        this.users.add(userID);
    }

    /** 
     * @param groupID
     */
    public void addGroup(SysEntry groupID) {
        this.groups.add(groupID);
    }

    /** 
     * @return List<String>
     */
    public List<SysEntry> getUsers() {
        return this.users;
    }

    /** 
     * @return List<String>
     */
    public List<SysEntry> getGroups() {
        return this.groups;
    }

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        
    }

    public boolean containsUser(String userName) {
        return false;
    }
}