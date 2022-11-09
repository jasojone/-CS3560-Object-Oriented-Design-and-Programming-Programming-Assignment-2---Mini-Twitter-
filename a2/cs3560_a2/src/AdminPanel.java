
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
public class AdminPanel implements ActionListener {
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

        //when the user clicks on open user view, the user view should open up in a new window
        JButton openUserViewButton = new JButton("Open User View");
        openUserViewButton.setBounds(500, 185, 400, 20);
        openUserViewButton.addActionListener(this);
        openUserViewButton.setActionCommand("generateUserPanel");




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
        //TODO: put addUser into a separate class and call it here
        String userName = this.addUserTextArea.getText();
        // append the word user to the end of the user name
        userName = userName + " (user)";
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
        // check to see if the user is already in the selected group
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
        this.addUserTextArea.setText("");
        this.treeRoot.updateUI();
    }

    public void addGroup() {
        String groupName = this.addGroupTextArea.getText();
        // append the word group to the end of the group name
        groupName = groupName + " (group)";

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
        // check to see if the group is already in the root
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
        // change the text area to empty
        this.addGroupTextArea.setText("");
        this.treeRoot.updateUI();
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("addUser")) {
            this.addUser();
        } else if (action.equals("addGroup")) {
            this.addGroup();
        } else if (action.equals("generateUserPanel")) {
            this.generateUserPanel(action);
        }
    }

    // userPanel is the panel that will be displayed when a user is selected in the tree view panel on the left side then generate the user panel
    // the user panel will have the users name, a button to follow the user, a list of the users followers, 
    // a list of the users following, a text area to enter a message, a button to post the message, 
    // a list of the users news feed
    public void generateUserPanel(String userName) {
        // create the user panel
        // onen a new frame for the user panel for the user that was selected
        JFrame userFrame = new JFrame("User Panel");
        userFrame.setSize(960, 600);
        userFrame.setLayout(null);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setResizable(false);
        userFrame.setVisible(true);


        
        JPanel userPanel = new JPanel();
        userPanel.setLayout(null);
        userPanel.setBounds(0, 0, 960, 600);
        userPanel.setBackground(Color.WHITE);

        // create the user name label
        JLabel userNameLabel = new JLabel(userName);
        userNameLabel.setBounds(10, 10, 200, 20);

        // create the follow button
        JButton followButton = new JButton("Follow");
        followButton.setBounds(10, 35, 200, 20);
        followButton.addActionListener(this);
        followButton.setActionCommand("follow");

        // create the followers label
        JLabel followersLabel = new JLabel("Followers");
        followersLabel.setBounds(10, 60, 200, 20);

        // create the followers list
        JList followersList = new JList();
        followersList.setBounds(10, 85, 200, 200);

        // create the following label
        JLabel followingLabel = new JLabel("Following");
        followingLabel.setBounds(10, 290, 200, 20);

        // create the following list
        JList followingList = new JList();
        followingList.setBounds(10, 315, 200, 200);

        // create the message label
        JLabel messageLabel = new JLabel("Message");
        messageLabel.setBounds(220, 10, 200, 20);

        // create the message text area
        JTextArea messageTextArea = new JTextArea();
        messageTextArea.setBounds(220, 35, 200, 200);

        // create the post message button
        JButton postMessageButton = new JButton("Post Message");
        postMessageButton.setBounds(220, 240, 200, 20);
        postMessageButton.addActionListener(this);
        postMessageButton.setActionCommand("postMessage");

        // create the news feed label
        JLabel newsFeedLabel = new JLabel("News Feed");
        newsFeedLabel.setBounds(430, 10, 200, 20);

        // create the news feed list
        JList newsFeedList = new JList();
        newsFeedList.setBounds(430, 35, 200, 200);

        // add the components to the user frame
        userFrame.add(userPanel);

        // add all the components to the user panel
        userPanel.add(userNameLabel);
        userPanel.add(followButton);
        userPanel.add(followersLabel);
        userPanel.add(followersList);
        userPanel.add(followingLabel);
        userPanel.add(followingList);
        userPanel.add(messageLabel);
        userPanel.add(messageTextArea);
        userPanel.add(postMessageButton);
        userPanel.add(newsFeedLabel);
        userPanel.add(newsFeedList);

    }

}