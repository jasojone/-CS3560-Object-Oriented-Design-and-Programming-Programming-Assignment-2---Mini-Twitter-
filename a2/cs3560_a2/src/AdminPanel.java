
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
public class AdminPanel implements ActionListener, ListSelectionListener {
    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    // admin panel components
    private static AdminPanel instance = null;
    private JFrame frame;
    private JTree treeRoot;
    private JScrollPane treeView;
    private JTextArea addUserTextArea;
    private JTextArea addGroupTextArea;
    private JTextField userTotal;
    private JTextField groupTotal;
    private JTextField messageTotal;
    private JTextField positivePercentage;

    // user panel components
    private JList followingList;
    private DefaultListModel followingListModel;
    private JTextField followers;
    private JTextField followings;
    private JTextField newsFeed;
    private JTextArea followUserTextArea;
    private JTextArea postMessageTextArea;

    private AdminPanel() {
    }

    /**
     * @return AdminPanel
     */
    public static AdminPanel getInstance() {
        if (AdminPanel.instance == null) {
            instance = new AdminPanel();
        }
        return instance;
    }

    public void adminPanelUI() {
        if (this.frame != null) {
            return;
        }
        this.frame = new JFrame("AdminUI");
        Group root = new Group("Root");
       
        Font font = new Font("Courier", Font.PLAIN, 12);
        // tree
        JLabel treeLabel = new JLabel("Groups and Users");
        treeLabel.setBounds(30, 5, 400, 20);
        this.treeRoot = new JTree(root);
        this.treeRoot.setBounds(30, 30, 450, 500);
        this.treeRoot.setFont(font);
        this.treeRoot.setBorder(BorderFactory.createLineBorder(Color.black));
        this.treeView = new JScrollPane(this.treeRoot);
        this.treeView.setBounds(30, 30, 450, 500);
        this.treeView.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.treeView.setBorder(BorderFactory.createLineBorder(Color.black));
        this.treeRoot.setShowsRootHandles(true);
    




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
        // add test user
        User testUser = new User("testUser");
        root.addUser(testUser);
        DefaultMutableTreeNode testUserNode = new DefaultMutableTreeNode(testUser);
        root.add(testUserNode);

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

        // when the user clicks on open user view, the user view should open up in a new
        // window
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

    public void addUser(){
        String userName = this.addUserTextArea.getText();
       // check for empty string input
        if (userName == null || userName.equals("")) {
            JOptionPane.showMessageDialog(this.frame, "Please enter a user name");
            return;
        }
        //  check to see if user already exists in the list
        
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.treeRoot.getModel().getRoot();
        // Enumeration<TreeNode> children = root.depthFirstEnumeration();
        // while (children.hasMoreElements()) {
        //     DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
        //     if (child.getUserObject() instanceof User) {
        //         User user = (User) child.getUserObject();
        //         if (user.containsUser(null, userName)) {
        //             JOptionPane.showMessageDialog(this.frame, "User already exists");
        //             return;
        //         }
        //     }
        // }

        // create a selected node 
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.treeRoot.getLastSelectedPathComponent();
        // if the selected node is null, ask the user to select a node
        if (selectedNode == null) {
            JOptionPane.showMessageDialog(this.frame, "Please select a node");
            return;
        }
        // if the selected node is a user, ask the user to select a group or root
        if (selectedNode.getUserObject() instanceof User) {
            JOptionPane.showMessageDialog(this.frame, "Cannot add a user to a user");
            return;
        }
        // create a root reference
        // DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.treeRoot.getModel().getRoot();
    


        // create a user
        User user = new User(userName);
        // if the selected node is the root, add the user to the root
        if (selectedNode == root) {
            ((Group) root).addUser(user);
            DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user);
            root.add(userNode);
            this.treeRoot.updateUI();
            JOptionPane.showMessageDialog(this.frame, "User added successfully");
            this.addUserTextArea.setText("");
            // this.updateUserTotal();
            return;
        }

        // if the selected node is a group, check to see if user already exists in the group and if 
        // not then add the user to the group, and update the tree
        if (selectedNode.getUserObject() instanceof Group) {
            if (((Group) selectedNode.getUserObject()).getUsers().contains(user)) {
                JOptionPane.showMessageDialog(this.frame, "User already exists");
                return;
            }
            ((Group) selectedNode.getUserObject()).addUser(user);
            DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user);
            selectedNode.add(userNode);
            this.treeRoot.updateUI();
            JOptionPane.showMessageDialog(this.frame, "User added successfully");
            this.addUserTextArea.setText("");
            // this.updateUserTotal();
            return;


        }

    }
    // when text is entered into the Group text area, it will create and add the selected node
    // if the node is the root, it will add the user to the root
    // if the node is a group, it will prompt the user to select the root
    // if the selected node is a user, it will not add the user and prompt the user to select the root
    // if the group already exists, it will not add the group and prompt the user to select a different name
    // if the group is added, it will update the tree
    // if the group is not added, it will display an error message
    // if the group is added, it will display a success message
    // if the group is added, it will clear the text area
    // if the group is added, it will update the group total
    //
    public void addGroup(){
        String groupName = this.addGroupTextArea.getText();
        // check for empty string input
        if (groupName == null || groupName.equals("")) {
            JOptionPane.showMessageDialog(this.frame, "Please enter a group name");
            return;
        }
        // create a selected node 
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.treeRoot.getLastSelectedPathComponent();
        // if the selected node is null, ask the user to select a node
        if (selectedNode == null) {
            JOptionPane.showMessageDialog(this.frame, "Please select a node");
            return;
        }
        // if the selected node is a user, ask the user to select a group or root
        if (selectedNode.getUserObject() instanceof User) {
            JOptionPane.showMessageDialog(this.frame, "Cannot add a group to a user");
            return;
        }
        // if the selected node is a group, ask the user to select the root
        if (selectedNode.getUserObject() instanceof Group) {
            JOptionPane.showMessageDialog(this.frame, "Cannot add a group to a group");
            return;
        }
        // create a root reference
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.treeRoot.getModel().getRoot();
        // if the selected node is the root, add the group to the root
        if (selectedNode == root) {
            // check to see if the group already exists in the tree
            if (root.toString().contains(groupName)) {
                JOptionPane.showMessageDialog(this.frame, "Group already exists");
                return;
            }
            // create a group
            Group group = new Group(groupName);
            ((Group) root).addGroup(group);
            DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(group);
            root.add(groupNode);
            this.treeRoot.updateUI();
            JOptionPane.showMessageDialog(this.frame, "Group added successfully");
            this.addGroupTextArea.setText("");
            // this.updateGroupTotal();
            return;
        }

    }

    /**
     * @description: when the user clicks on the open user view button, the user
     *               view
     * @param e ActionEvent
     * @return void
     */
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("addUser")) {
            this.addUser();
        } else if (action.equals("addGroup")) {
            this.addGroup();
        } else if (action.equals("generateUserPanel")) {
            this.UserPanelUI(action);
        } else if (action.equals("showUserTotal")) {
            this.showUserTotal();
        } else if (action.equals("showGroupTotal")) {
            this.showUserTotal();
        } else if (action.equals("showMessageTotal")) {
            this.showUserTotal();
        } else if (action.equals("showPositivePercentage")) {
            this.showPositivePercentage();
        } else if (action.equals("followUser")) {
            this.followUser();
        } else if (action.equals("postMessage")) {
            this.postMessage();
        }
    }

    private void postMessage() {
    }

    private void showPositivePercentage() {
    }

    private void showUserTotal() {
    }

    /**
     * @param userName
     */
    // userPanel is the panel that will be displayed when a user is selected in the
    // tree view panel on the left side then generate the user panel
    // the user panel will have the users name, a button to follow the user, a list
    // of the users followers,
    // a list of the users following, a text area to enter a message, a button to
    // post the message,
    // a list of the users news feed
    public void UserPanelUI(String userName) {
        JFrame userFrame = new JFrame("User Panel");

        userFrame.setSize(495, 500);
        userFrame.setLayout(null);
        userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userFrame.setResizable(false);
        userFrame.setVisible(true);
        // Font font = new Font("Courier", Font.PLAIN, 12);
        // get the user name from the selected node
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.treeRoot.getLastSelectedPathComponent();
        String selectedNodeName = selectedNode.getUserObject().toString();

        JPanel userPanel = new JPanel();
        userPanel.setLayout(null);
        userPanel.setBounds(0, 0, 960, 600);
        userPanel.setBackground(Color.WHITE);

        // create the user name label at the top left of the user panel
        JLabel userNameLabel = new JLabel(selectedNodeName);
        userNameLabel.setBounds(30, 10, 200, 20);

        // create the follow label
        JLabel followUserLabel = new JLabel("Enter a user to follow");
        followUserLabel.setBounds(30, 35, 200, 20);

        // text area for the user to enter the user they want to follow
        JTextArea followUserTextArea = new JTextArea();
        followUserTextArea.setBounds(30, 60, 200, 20);
        followUserTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // create the follow button
        JButton followButton = new JButton("Follow");
        followButton.setBounds(30, 85, 200, 20);
        followButton.addActionListener(this);
        followButton.setActionCommand("follow");

        // 

        // create the followers label
        JLabel followersLabel = new JLabel("Followers");
        followersLabel.setBounds(250, 35, 200, 20);

        followingListModel = new DefaultListModel();


        // create the following list and put it in a scroll pane
        followingList = new JList(followingListModel);
        followingList.setBounds(250, 60, 200, 60);
        followingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // followingList.setSelectedIndex(0);
        followingList.addListSelectionListener(this);
        followingList.setVisibleRowCount(5);
        followingList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // create a scroll pane for the following list
        JScrollPane followingScrollPane = new JScrollPane(followingList);
        followingScrollPane.setBounds(250, 60, 200, 60);
        followingScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // create the message label
        JLabel messageLabel = new JLabel("Message");
        messageLabel.setBounds(30, 145, 200, 20);

        // create a text box for the message outlined in black
        JTextArea messageTextArea = new JTextArea();
        messageTextArea.setBounds(30, 170, 420, 60);
        messageTextArea.setBorder(BorderFactory.createLineBorder(Color.black));

        // create the post message button
        JButton postMessageButton = new JButton("Post Message");
        postMessageButton.setBounds(30, 235, 200, 20);
        postMessageButton.addActionListener(this);
        postMessageButton.setActionCommand("postMessage");

        // create the news feed label
        JLabel newsFeedLabel = new JLabel("News Feed");
        newsFeedLabel.setBounds(30, 260, 200, 20);

        // create the news feed list
        JList newsFeedList = new JList();
        newsFeedList.setBounds(30, 285, 420, 100);
        newsFeedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        newsFeedList.setSelectedIndex(0);
        newsFeedList.setVisibleRowCount(5);
        newsFeedList.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // create a scroll pane for the news feed list
        JScrollPane newsFeedScrollPane = new JScrollPane(newsFeedList);
        newsFeedScrollPane.setBounds(30, 285, 420, 100);
        newsFeedScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // add the components to the user frame
        userFrame.add(userPanel);

        // add all the components to the user panel
        userPanel.add(userNameLabel);
        userPanel.add(followUserLabel);
        userPanel.add(followUserTextArea);
        userPanel.add(followButton);
        userPanel.add(followersLabel);
        userPanel.add(followingScrollPane);
        userPanel.add(messageLabel);
        userPanel.add(messageTextArea);
        userPanel.add(postMessageButton);
        userPanel.add(newsFeedLabel);
        userPanel.add(newsFeedScrollPane);


    }

    // TODO create a method to add a user to the following list
    // when the follow button is clicked, it will add the user to the following list and attach the user to the selected user
    // when the user is added to the following list, it will also add the user to the followers list of the user they are following 
    public void followUser(){
        // get the user name from the text area
        String userToFollow = followUserTextArea.getText();
        // check if the user is in the tree
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.treeRoot.getModel().getRoot();
        if (root.toString().contains(userToFollow)){
            // add the user to the following list
            followingListModel.addElement(userToFollow);
            // add the user to the followers list of the user they are following
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) this.treeRoot.getLastSelectedPathComponent();
            selectedNode.add(new DefaultMutableTreeNode(userToFollow));
            // update the tree
            this.treeRoot.updateUI();
        } else {
            // if the user is not in the tree, display a message saying that the user is not in the tree
            JOptionPane.showMessageDialog(null, "The user you are trying to follow is not a user");
        }
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub

    }



}