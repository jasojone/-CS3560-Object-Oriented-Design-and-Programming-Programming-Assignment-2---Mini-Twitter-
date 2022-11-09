
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.tree.*;
//this class needs to be a singleton. 
// To create a singleton class, we must follow the steps, given below:

// 1. Ensure that only one instance of the class exists.

// 2. Provide global access to that instance by

// Declaring all constructors of the class to be private.
// Providing a static method that returns a reference to the instance. The lazy initialization concept is used to write the static methods.
// The instance is stored as a private static variable.
// https://www.geeksforgeeks.org/singleton-class-java/

/* FrameDemo.java requires no other files. */
public class AdminPanel implements ActionListener{
    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static AdminPanel instance = null;
    private JFrame frame;
    private JTree treeRoot;
    private JScrollPane treeView;
    private JTextArea addUserTextArea;
    private JTextArea addGroupTextArea;

    private AdminPanel() {
    }

    public static AdminPanel getInstance() {
        if (AdminPanel.instance == null) {
            instance = new AdminPanel();
        }
        return instance;
    }

    public void createAndShowGUI() {
        if (this.frame != null) {
            return;
        }
        this.frame = new JFrame("AdminUI");
        Group root = new Group("Root");
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(root);
        // general components
        Font font = new Font("Courier", Font.PLAIN, 12);

        // tree
        JLabel treeLabel = new JLabel("Tree");
        treeLabel.setBounds(30, 5, 400, 20);
        this.treeRoot = new JTree(top);
        this.treeRoot.setBounds(30, 30, 450, 500);
        // this.treeRoot.addTreeSelectionListener(this);
        this.treeRoot.setFont(font);
        this.treeRoot.setBorder(BorderFactory.createLineBorder(Color.black));
        this.treeView = new JScrollPane(this.treeRoot);
        this.treeView.setBounds(30, 30, 450, 500);
        this.treeView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.treeView.setBorder(BorderFactory.createLineBorder(Color.black));
        
    

        // text area for adding user
        JLabel addUserLabel = new JLabel("Add User");
        addUserLabel.setBounds(500, 5, 400, 20);
        addUserLabel.setFont(font);
        this.addUserTextArea = new JTextArea();
        this.addUserTextArea.setBounds(500, 30, 400, 20);
        this.addUserTextArea.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton addUserButton = new JButton("Add User");
        addUserButton.setBounds(500, 60, 400, 20);
        addUserButton.addActionListener(this);
        addUserButton.setActionCommand("addUser");

        // text area for adding group
        JLabel addGroupLabel = new JLabel("Add Group");
        addGroupLabel.setBounds(500, 85, 400, 20);
        addGroupLabel.setFont(font);
        this.addGroupTextArea = new JTextArea();
        this.addGroupTextArea.setBounds(500, 110, 400, 20);
        this.addGroupTextArea.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton addGroupButton = new JButton("Add Group");
        addGroupButton.setBounds(500, 135, 400, 20);
        addGroupButton.addActionListener(this);
        addGroupButton.setActionCommand("addGroup");

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
        frame.add(addUserTextArea);
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
    }

    // when text is entered into the user text area, it will created and add the
    // user to the tree and the user will be added to the root
    public void addUser() {
        String userName = this.addUserTextArea.getText();
        // change the text area to empty
        this.addUserTextArea.setText("");
        if (userName.length() == 0) {
            return;
        }
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.treeRoot.getModel().getRoot();
        DefaultMutableTreeNode user = new DefaultMutableTreeNode(userName);
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.treeRoot.getLastSelectedPathComponent();
        // check to see if the user already exists
        if (selectedNode != null) {
            Enumeration children = selectedNode.children();
            while (children.hasMoreElements()) {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
                if (child.getUserObject().equals(userName)) {
                    return;
                }
            }
        }
        //check to see if the user is already in the selected group
        if (selectedNode != null) {
            if (selectedNode.getUserObject().equals(userName)) {
                return;
            }
        }

        if (selectedNode == null) {
            root.add(user);
        } else {
            selectedNode.add(user);
        }
        this.treeRoot.updateUI();
    }

    public void addGroup() {
        String groupName = this.addGroupTextArea.getText();
        // change the text area to empty
        this.addGroupTextArea.setText("");
        if (groupName.length() == 0) {
            return;
        }
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.treeRoot.getModel().getRoot();
        DefaultMutableTreeNode group = new DefaultMutableTreeNode(groupName);
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.treeRoot.getLastSelectedPathComponent();
        // check to see is the selected node is a user if it is then return
        if (selectedNode != null) {
            if (selectedNode.isLeaf()) {
                return;
            }
        }
        // check to see if the group already exists
        if (selectedNode != null) {
            Enumeration children = selectedNode.children();
            while (children.hasMoreElements()) {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
                if (child.getUserObject().equals(groupName)) {
                    return;
                }
            }
        }
        //check to see if the group is already in the root
        Enumeration children = root.children();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
            if (child.getUserObject().equals(groupName)) {
                return;
            }
        }
        
        if (selectedNode == null) {
            root.add(group);
        } else {
            selectedNode.add(group);
        }
        this.treeRoot.updateUI();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("addUser")) {
            addUser();
        } else if (e.getActionCommand().equals("addGroup")) {
            addGroup();
        }
    }

}