
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Group;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
//this class needs to be a singleton. 

/* FrameDemo.java requires no other files. */
public class AdminPanel implements ActionListener, TreeSelectionListener {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private  static AdminPanel instance = null;
    private  JFrame frame;
    private  JTree tree;
    private  JScrollPane treeView;
    private  JTextArea addUsertextArea;
    private  JTextArea addGroupTextArea;
    private AdminPanel(){}

    public static AdminPanel getInstance() {
        if (AdminPanel.instance == null) {
            instance = new AdminPanel();
        }
        return instance;
    }

    public void createAndShowGUI() {
        if (this.frame!= null) {
            return;
        }
        this.frame = new JFrame("AdminUI");
        // Group root = new Group("Root");
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Root");
        // general components
        Font font = new Font("Courier", Font.PLAIN, 12);

        //tree
        JLabel treeLabel = new JLabel("Tree");
        treeLabel.setBounds(30, 5, 400, 20);
        this.tree = new JTree(top);
        this.tree.setBounds(30, 30, 450, 500);
        this.tree.addTreeSelectionListener(this);
        this.tree.setBorder(BorderFactory.createLineBorder(Color.black));
        this.treeView = new JScrollPane(this.tree);
        this.treeView.setBounds(30, 30, 450, 500);
        this.treeView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        // this.treeView.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        // text area for adding user
        JLabel addUserLabel = new JLabel("Add User");
        addUserLabel.setBounds(500, 5, 400, 20);
        addUserLabel.setFont(font);
        this.addUsertextArea = new JTextArea();
        this.addUsertextArea.setBounds(500, 30, 400, 20);
        this.addUsertextArea.setBorder(BorderFactory.createLineBorder(Color.black));
        // add user button
        JButton addUserButton = new JButton("Add User");
        addUserButton.setBounds(500, 60, 400, 20);
        addUserButton.addActionListener(this);

        // text area for adding group
        JLabel addGroupLabel = new JLabel("Add Group");
        addGroupLabel.setBounds(500, 85, 400, 20);
        addGroupLabel.setFont(font);
        this.addGroupTextArea = new JTextArea();
        this.addGroupTextArea.setBounds(500, 110, 400, 20);
        this.addGroupTextArea.setBorder(BorderFactory.createLineBorder(Color.black));



        // add group button
        JButton addGroupButton = new JButton("Add Group");
        addGroupButton.setBounds(500, 135, 400, 20);
        addGroupButton.addActionListener(this);

        // open user view button
        JButton openUserViewButton = new JButton("Open User View");
        openUserViewButton.setBounds(500, 185, 400, 20);
        openUserViewButton.addActionListener(this);

        // show user total button
        JButton showUserTotalButton = new JButton("Show User Total");
        showUserTotalButton.setBounds(500, 210, 400, 20);
        showUserTotalButton.addActionListener(this);

        // show group total button
        JButton showGroupTotalButton = new JButton("Show Group Total");
        showGroupTotalButton.setBounds(500, 235, 400, 20);
        showGroupTotalButton.addActionListener(this);

        // show message total button
        JButton showMessageTotalButton = new JButton("Show Message Total");
        showMessageTotalButton.setBounds(500, 260, 400, 20);
        showMessageTotalButton.addActionListener(this);

        // show positive percentage button
        JButton showPositivePercentageButton = new JButton("Show Positive Percentage");
        showPositivePercentageButton.setBounds(500, 285, 400, 20);
        showPositivePercentageButton.addActionListener(this);

        frame.add(treeLabel);
        frame.add(treeView);
        frame.add(addUserLabel);
        frame.add(addUsertextArea);
        frame.add(addGroupLabel);
        frame.add(addGroupTextArea);
        frame.add(addUserButton);
        frame.add(addGroupButton);
        frame.add(openUserViewButton);
        frame.add(showUserTotalButton);
        frame.add(showGroupTotalButton);
        frame.add(showMessageTotalButton);
        frame.add(showPositivePercentageButton);

        frame.setSize(960, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setVisible(true);
    }
    // add user and add to the treeView when the button is clicked  
    public void addUser() {
        String userName = this.addUsertextArea.getText();
        if (userName == null || userName.length() == 0) {
            return;
        }
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.tree.getLastSelectedPathComponent();
        if (selectedNode == null) {
            return;
        }
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(userName);
        selectedNode.add(newNode);
        this.tree.updateUI();
    }
    // add group and add to the treeView when the button is clicked
    public void addGroup() {
        String groupName = this.addGroupTextArea.getText();
        if (groupName == null || groupName.length() == 0) {
            return;
        }
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.tree.getLastSelectedPathComponent();
        if (selectedNode == null) {
            return;
        }
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(groupName);
        selectedNode.add(newNode);
        this.tree.updateUI();
    }
    // open user view when the button is clicked
    // public void openUserView() {
    //     DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.tree.getLastSelectedPathComponent();
    //     if (selectedNode == null) {
    //         return;
    //     }
    //     String userName = selectedNode.getUserObject().toString();
    //     final UserView UserView = UserView.getInstance();
    //     UserView.createAndShowGUI(userName);
    // }

    // // show user total
    // private void showUserTotal() {
    //     DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.tree.getLastSelectedPathComponent();
    //     if (selectedNode == null) {
    //         return;
    //     }
    //     int userTotal = 0;
    //     Enumeration<DefaultMutableTreeNode> children = selectedNode.children();
    //     while (children.hasMoreElements()) {
    //         DefaultMutableTreeNode child = children.nextElement();
    //         if (child.isLeaf()) {
    //             userTotal++;
    //         }
    //     }
    //     JOptionPane.showMessageDialog(this.frame, "User Total: " + userTotal);
    // }

    // // show group total
    // private void showGroupTotal() {
    //     DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.tree.getLastSelectedPathComponent();
    //     if (selectedNode == null) {
    //         return;
    //     }
    //     int groupTotal = 0;
    //     Enumeration<DefaultMutableTreeNode> children = selectedNode.children();
    //     while (children.hasMoreElements()) {
    //         DefaultMutableTreeNode child = children.nextElement();
    //         if (!child.isLeaf()) {
    //             groupTotal++;
    //         }
    //     }
    //     JOptionPane.showMessageDialog(this.frame, "Group Total: " + groupTotal);
    // }

    // // show message total
    // private void showMessageTotal() {
    //     DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.tree.getLastSelectedPathComponent();
    //     if (selectedNode == null) {
    //         return;
    //     }
    //     int messageTotal = 0;
    //     Enumeration<DefaultMutableTreeNode> children = selectedNode.children();
    //     while (children.hasMoreElements()) {
    //         DefaultMutableTreeNode child = children.nextElement();
    //         if (child.isLeaf()) {
    //             messageTotal += UserView.getInstance().getMessageTotal((String) child.getUserObject());
    //         }
    //     }
    //     JOptionPane.showMessageDialog(this.frame, "Message Total: " + messageTotal);
    // }

    // show positive percentage
    // private void showPositivePercentage() {
    //     DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.tree.getLastSelectedPathComponent();
    //     if (selectedNode == null) {
    //         return;
    //     }
    //     int positiveTotal = 0;
    //     int messageTotal = 0;
    //     Enumeration<DefaultMutableTreeNode> children = selectedNode.children();
    //     while (children.hasMoreElements()) {
    //         DefaultMutableTreeNode child = children.nextElement();
    //         if (child.isLeaf()) {
    //             positiveTotal += UserView.getInstance().getPositiveTotal((String) child.getUserObject());
    //             messageTotal += UserView.getInstance().getMessageTotal((String) child.getUserObject());
    //         }
    //     }
    //     if (messageTotal == 0) {
    //         JOptionPane.showMessageDialog(this.frame, "Positive Percentage: 0%");
    //     } else {
    //         JOptionPane.showMessageDialog(this.frame, "Positive Percentage: " + (positiveTotal * 100 / messageTotal) + "%");
    //     }
    // }



    @Override
    public void valueChanged(TreeSelectionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}