// You can add users/groups with Buttons and TextAreas. Of course, the TreeView should
// be updated as well whenever new users/groups are being added.
//
// The UserView class is used to show the user view. The user view has a text area to
// show the user ID, and a button to show the user total. The user total is the number
// of users in the user group that the user belongs to. For example, if the user belongs
// to the group A, and the group A contains 3 users, then the user total is 3. If the
// user belongs to the group B, and the group B contains 2 users, and the group B is
// included in the group A, and the group A contains 3 users, then the user total is 5.
// When you select a user in the tree, clicking on the Open User View button will open the
// User View as shown in Figure 2. You can open multiple User Views for different users.
// 8. In the User View, it will display the current users you are following in a ListView
// (followings). You can add new users to follow by using the TextArea and Button.
// Unfollow is not required. Displaying your followers is not required.
// 9. The User View also shows the current news feed list for this user in a ListView.
// 10. You can post a new Tweet with the TextArea and Button. Once you click the Post button.
// It will add the message to all your followers’ news feed list, as well as your own news
// feed list.
// 11. Whenever a new message is posted, all the followers’ news feed list view should be
// updated and refreshed automatically.

// The UserView class has the following methods:
// 1) a constructor that takes a user ID as a parameter;
// 2) a method to show the user total.

// The UserView class also has the following methods that are inherited from the user
// class:
// 1) a method to get the ID.
// 2) a method to get the list of followers.
// 3) a method to get the list of followings.
// 4) a method to add a follower.
// 5) a method to add a following.
// 6) a method to add a message to the news feed.
// 7) a method to get the news feed.
// 8) a method to get the list of users.
// 9) a method to get the list of groups.
// 10) a method to get the list of components.
// 11) a method to add a user.
// 12) a method to add a group.
// 13) a method to get the ID.
// 14) a method to get the list of users.
// 15) a method to get the list of groups.
// 16) a method to get the list of components.
//





// import java.awt.BorderLayout;
// import java.awt.Component;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.List;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JTextArea;

// public class UserView extends JFrame implements ActionListener, UserComponent {
//     private static final long serialVersionUID = 1L;
//     private String userID;
//     private JTextArea userIDTextArea;
//     private JButton showUserTotalButton;
//     private JPanel panel;
//     private UserComponent userComponent;
//     private List<Group> user;
    
//     public UserView(String userID) {
//         this.userID = userID;
//         this.userIDTextArea = new JTextArea();
//         this.showUserTotalButton = new JButton("Show User Total");
//         this.panel = new JPanel();
//         this.userComponent = new User(userID);
        
//         this.userIDTextArea.setText(this.userID);
//         this.userIDTextArea.setEditable(false);
//         this.showUserTotalButton.addActionListener(this);
        
//         this.panel.setLayout(new BorderLayout());
//         this.panel.add(this.userIDTextArea, BorderLayout.NORTH);
//         this.panel.add(this.showUserTotalButton, BorderLayout.SOUTH);
        
//         this.add(this.panel);
//         this.setTitle("User View");
//         this.setSize(300, 100);
//         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         this.setVisible(true);
//     }
    
//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource() == this.showUserTotalButton) {
//             this.showUserTotal();
//         }
//     }
    
//     public void showUserTotal() {
//         int userTotal = 0;
//         List<UserComponent> components = this.userComponent.getComponents();
//         for (UserComponent component : components) {
//             if (component instanceof User) {
//                 userTotal++;
//             }
//         }
//         this.userIDTextArea.setText(this.userID + " (" + userTotal + ")");
//     }
    
//     public String getID() {
//         return this.userComponent.getID();
//     }
    
//     public List<String> getFollowers() {
//         return this.userComponent.getFollowers();
//     }
    
//     public List<String> getFollowings() {
//         return this.userComponent.getFollowings();
//     }
    
//     public void addFollower(String followerID) {
//         this.userComponent.addFollower(followerID);
//     }
    
//     public void addFollowing(String followingID) {
//         this.userComponent.addFollower(followingID);
//     }
    
//     public void addMessage(TwitterMessage message) {
//         this.userComponent.addMessage(message);
//     }
    
//     public List<TwitterMessage> getNewsFeed() {
//         return this.userComponent.getNewsFeed();
//     }
    
//     public List<User> getUsers() {
//         return this.userComponent.getUsers();
//     }
    
//     public List<Group> getGroups() {
//         return this.user;
//     }

//     public UserView getInstance() {
//         return null;
//     }


