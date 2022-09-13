package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import human.User;

public class ProfilePage extends JFrame implements ActionListener, KeyListener {
	
	private User ownerAccount;
	private User guest;
	private JFrame homePage; // home page of the guest user
	
	private JPanel informationOfUser; //contains information1, information and follow button
	
	private JLabel information1; // nickname and profile photo of the user
	
	private JPanel informations2_3; // information2 + information3
	private JLabel information2; // real name, surname 
	private JLabel information3; // account type
	
	private JPanel buttons;
	private JButton follow; // according to guest user, it is follow or unfollow
	private JButton logOut;
	private JButton deleteAccount;
	
	private JScrollPane posts;
	private JScrollPane groups;
	private JScrollPane friends; 
	
	
	
	private ImageIcon profilePhoto; 
	
	

	public ProfilePage(User ownerAccount, User guest, JFrame home)  {
		
		this.ownerAccount = ownerAccount;
		this.guest = guest;
		this.homePage = home;
		
		
		informationOfUser = new JPanel();
		informationOfUser.setPreferredSize(new Dimension(0,130));
		informationOfUser.setLayout(new GridLayout(1,3));
		
		profilePhoto = new ImageIcon(ownerAccount.getProfilePhoto().getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH));
		
		information1 = new JLabel();
		information1.setText(ownerAccount.getNickname());
		information1.setIcon(profilePhoto);
		information1.setHorizontalTextPosition(JLabel.CENTER);
		information1.setVerticalTextPosition(JLabel.BOTTOM);
		information1.setForeground(Color.BLACK);
		information1.setFont(new Font("Arial",Font.BOLD,30));
		
		informations2_3 = new JPanel();
		informations2_3.setLayout(new GridLayout(2,1));
		
		information2 = new JLabel();
		information2.setText(ownerAccount.getRealName()+ownerAccount.getRealSurname());
		information2.setFont(new Font("Arial",Font.BOLD,30));
		information2.setForeground(Color.BLACK);
		
		information3 = new JLabel();
		information3.setText(ownerAccount.getAccountType());
		information3.setFont(new Font("Arial",Font.BOLD,30));
		information3.setForeground(Color.BLACK);
		
		informations2_3.add(information2);
		informations2_3.add(information3);
		
		buttons = new JPanel();
		buttons.setPreferredSize(new Dimension(0,130));
		
		
		
		deleteAccount= new JButton();
		deleteAccount.setForeground(Color.black);
		deleteAccount.setFocusable(false);
		deleteAccount.setFont(new Font("Arial",Font.BOLD,25));
		deleteAccount.setBorder(BorderFactory.createRaisedBevelBorder());
		deleteAccount.setBackground(new Color(240,240,0));
		deleteAccount.addActionListener(this);
		deleteAccount.setText("Delete Account");
		
		
		logOut= new JButton();
		logOut.setForeground(Color.black);
		logOut.setFocusable(false);
		logOut.setFont(new Font("Arial",Font.BOLD,25));
		logOut.setBorder(BorderFactory.createRaisedBevelBorder());
		logOut.setBackground(new Color(240,240,0));
		logOut.addActionListener(this);
		logOut.setText("Log Out");
		
		follow = new JButton();
		follow.setForeground(Color.black);
		follow.setFocusable(false);
		follow.setFont(new Font("Arial",Font.BOLD,25));
		follow.setBorder(BorderFactory.createRaisedBevelBorder());
		follow.setBackground(new Color(240,240,0));
		follow.addActionListener(this);
		
		
		
		if(guest.getFriends().containsKey(ownerAccount.getNickname())) { // guest follows the owner of the profile page
			
			follow.setText("Unfollow");
		}
		else{ // guest does not follow the owner of the profile page
			
			follow.setText("Follow");
			
		}
		
		
		informationOfUser.add(informations2_3);
		informationOfUser.add(information1);
		informationOfUser.add(buttons);
		
		if(!(ownerAccount.getNickname().equals(guest.getNickname()))) { // if the profile page is not guest user's own page, add the follow button ( follow and unfollow)
			
			buttons.setLayout(new GridLayout(1,1));
			buttons.add(follow);
			
		}
		else { // // if the profile page is guest user's own page, add log out and delete account buttons
			buttons.setLayout(new GridLayout(2,1));
			buttons.add(logOut);
			buttons.add(deleteAccount);
		}
		
		
			
		posts = new JScrollPane();
		
		groups = new JScrollPane();
		
		
		JPanel friendContainer = new JPanel();
		
		friendContainer.setLayout(new BoxLayout(friendContainer,BoxLayout.Y_AXIS));
		
		friends = new JScrollPane(friendContainer);

		friends.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	

	
		
		
		if((ownerAccount.getNickname().equals(guest.getNickname())) || (guest.getFriends().containsKey(ownerAccount.getNickname())) ) {
			
			 //  if the profile page is guest user's own page or guest follows the owner of the profile page add friends of the owner of the profile page
			
			try {
				for(String key : ownerAccount.getFriends().keySet()) {
					
					 ImageIcon profilePhoto = new ImageIcon(ownerAccount.getFriends().get(key).getProfilePhoto().getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH));
					 JButton friend = new JButton();
					 friend.setIcon(profilePhoto);
					 friend.setSize(20, 15);
					 friend.setText(ownerAccount.getFriends().get(key).getNickname());
					 friend.setFocusable(false);
					 friend.setForeground(Color.black);
					 friend.setBackground(new Color(240,240,0));
					 friend.setBorder(BorderFactory.createRaisedBevelBorder());
					 friend.setFont(new Font("Consolas",Font.BOLD,20));
					 friend.addActionListener(this);
					 
					 
					 friendContainer.add(friend);
					 
					 
				}
			}
			catch(NullPointerException e) {
				
			}
		
			
			
			
		}
			
		
		
		this.setTitle("SuperDude | This is your profile :)");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1200, 800);
		this.getContentPane().setBackground(Color.white);
		this.setIconImage((new ImageIcon("superman-logo.png")).getImage());
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.add(informationOfUser, BorderLayout.NORTH);
		this.add(posts, BorderLayout.CENTER);
		this.add(friends, BorderLayout.WEST);
		this.add(groups, BorderLayout.EAST);
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		 if(e.getSource() == follow) { // guest presses follow button
			 if(follow.getText().equals("Follow")) { // guest was not following owner of the profile page 
				 
				 guest.follow(ownerAccount); // follows the owner of the profile page
				 follow.setText("Unfollow"); // text of the button is set to be unfollow
				 
			 }
			 else if(follow.getText().equals("Unfollow")) { // guest was following owner of the profile page
				 
				 guest.unfollow(ownerAccount); // unfollows the owner of the profile page
				 follow.setText("Follow");  // text of the button is set to be follow
			 }
		 }
		 
		 else if(e.getSource() == logOut) {// guest presses log out button
			 
			 this.dispose(); // profile page is closed
			 homePage.dispose(); // home page is closed
			 new EntrancePage(); // entrance page is opened
			 
		 }
		 else if(e.getSource() == deleteAccount) { // guest presses delete account button
			 
			 JOptionPane.showMessageDialog(this ,"We are sorry to loose you Kyrptonian :(", "Bye :((", JOptionPane.WARNING_MESSAGE);
			 
			 User.deleteUser(ownerAccount); // guest is deleted from the users with method of User class
			 this.dispose(); //profile page is closed
			 homePage.dispose(); // home page is closed
			 new EntrancePage(); // entrance page is opened
			 
		 }
		 else { // if pressed button is friends of the profile page owner's friends
			  new ProfilePage(User.getNickNameUserCombination().get(((JButton) e.getSource()).getText()), this.guest, this.homePage); // profile page of the clicked friend is opened
			  this.dispose(); // previous profile page is closed
		 }
		 
		
	}
	
	

}
