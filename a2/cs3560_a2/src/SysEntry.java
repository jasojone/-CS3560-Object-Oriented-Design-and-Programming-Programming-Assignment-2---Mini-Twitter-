import java.util.List;
// base class for the users and groups 


import javax.swing.tree.DefaultMutableTreeNode;


public abstract class SysEntry extends DefaultMutableTreeNode implements Visitable {
    private String id;
    
    /** 
     * @return String
     * {@summary} returns the ID of the user or group
     * 
     */
    // constructor
    public SysEntry(String id) {
        this.id = id;
    }
    
    public String getID() {
        return this.id;
    }

    public String toString() {
        return this.id;
    }
    

}
