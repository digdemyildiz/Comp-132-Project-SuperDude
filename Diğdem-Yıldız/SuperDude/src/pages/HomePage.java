package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import human.User;

public class HomePage extends JFrame  implements ActionListener, KeyListener{

	private User ownerAccount;
	
	private JPanel menu;
	private JPanel posts;
	private JPanel search;
	
	private JButton goProfile;
	private JButton createContent;
	private JLabel logoOfApplication;
	
	private JTextField searchBar;
	private JButton searchButton;
	private JLabel accountType;
	
	
	private ImageIcon profilePhoto;
	
	
	
	
	
	public HomePage(User u) {
		
		ownerAccount = u;
		profilePhoto = new ImageIcon(ownerAccount.getProfilePhoto().getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH));
		
		
		
		
		menu = new JPanel();
		menu.setBackground(new Color(51,51,255));
		menu.setPreferredSize( new Dimension(800,100));
		menu.setLayout(new BorderLayout());
		
		
		goProfile = new JButton("Profile");
		goProfile.setForeground(Color.black);
		goProfile.setBackground(new Color(240,240,0));
		goProfile.setPreferredSize( new Dimension(200,100));
		goProfile.setFocusable(false);
		goProfile.setBorder(BorderFactory.createRaisedBevelBorder());
		goProfile.setFont(new Font("Arial",Font.BOLD,15));
		goProfile.setIcon(profilePhoto);
		goProfile.setHorizontalTextPosition(JButton.CENTER);
		goProfile.setVerticalTextPosition(JButton.BOTTOM);
		goProfile.addActionListener(this);
		
		createContent = new JButton("New Post Create");
		createContent.setPreferredSize( new Dimension(30,100));
		createContent.setForeground(Color.black);
		createContent.setFocusable(false);
		createContent.setFont(new Font("Arial",Font.BOLD,25));
		createContent.setBorder(BorderFactory.createRaisedBevelBorder());
		createContent.setBackground(new Color(240,240,0));
		createContent.addActionListener(this);
		
		logoOfApplication = new JLabel();
		logoOfApplication.setText("SuperDude");
		logoOfApplication.setForeground(new Color(255,50,50));
		logoOfApplication.setFont(new Font("Arial",Font.BOLD,30));
		logoOfApplication.setPreferredSize(new Dimension(180,100));
		
		
		menu.add(goProfile,BorderLayout.WEST);
		menu.add(createContent, BorderLayout.CENTER);
		menu.add(logoOfApplication,BorderLayout.EAST);
		
		search = new JPanel();
		search.setBackground(Color.BLACK);
		search.setPreferredSize( new Dimension(800,60));
		search.setLayout(new BorderLayout());
		
		
		searchButton = new JButton("Search");
		searchButton.setPreferredSize(new Dimension(200,40));
		searchButton.setFocusable(false);
		searchButton.setForeground(Color.black);
		searchButton.setBackground(new Color(240,240,0));
		searchButton.setBorder(BorderFactory.createRaisedBevelBorder());
		searchButton.setFont(new Font("Consolas",Font.ITALIC,20));
		searchButton.addActionListener(this);
		
		searchBar = new JTextField();
		searchBar.setFont(new Font("Consolas",Font.PLAIN,20));
		searchBar.setForeground(new Color(240,240,0));
		searchBar.setBackground(Color.black);
		searchBar.setCaretColor(new Color(240,240,0));
		searchBar.setPreferredSize(new Dimension(100,40));
		searchBar.setText("Search users, groups... ");
		searchBar.addKeyListener(this);
	
		
		accountType = new JLabel();
		accountType.setText(u.getAccountType());
		accountType.setForeground(new Color(240,240,0));
		accountType.setFont(new Font("Arial",Font.BOLD,30));
		accountType.setPreferredSize(new Dimension(170,100));
		
		search.add(searchButton,BorderLayout.EAST);
		search.add(searchBar,BorderLayout.CENTER); 
		search.add(accountType,BorderLayout.WEST );
		
		
		
		this.setTitle("SuperDude | This is your home :) ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1200, 800);
		this.getContentPane().setBackground(Color.white);
		this.setIconImage((new ImageIcon("superman-logo.png")).getImage());
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		this.add(menu, BorderLayout.SOUTH);
		this.add(search,BorderLayout.NORTH);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == searchButton) {
			
			System.out.println("Searching is coming soon..");
		}
		else if(e.getSource() == goProfile ) { // if user clicks her own profile page button a profile page with guest and owner is created and both are the user clicked.
			
			new ProfilePage(ownerAccount, ownerAccount,this);
			
		}
		else if(e.getSource() == createContent) {
			
			System.out.println("Creating content is coming soon..");
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) { // if user presses a key informative messages from the JTextFiels are deleted
		if( e.getSource() ==searchBar &&searchBar.getText().equals("Search users, groups... ") ){
				
			
			searchBar.setText(null);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) { // if user releases a key and JTextField is empty, it sets the informative messages again
		
		if( e.getSource() ==searchBar && searchBar.getText().equals("") ){
				
			
			searchBar.setText("Search users, groups... ");
		}
		
		
	}

}
