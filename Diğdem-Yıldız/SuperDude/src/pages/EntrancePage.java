package pages;
import human.User;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EntrancePage implements ActionListener,KeyListener {
	
	private ImageIcon logoApplication = new ImageIcon("superman-logo.png");
	private JFrame entranceFrame;
	private JLabel nameApplication; // SuperDude
	private JLabel informationOfApplicaiton; // SuperDude helps you find friends and gives you a chance...
	private JLabel betweenButtons; // ------- line between log in and sign up buttons
	private JButton loginButton; 
	private JButton signUpButton;
	private JTextField nickNameEmail;
	private JTextField password;
	
	
	
	public EntrancePage (){
		
		nameApplication = new JLabel();
		nameApplication.setText("SuperDude"); // sets the text of the Jlabel
		nameApplication.setIcon(logoApplication); // superman logo
		nameApplication.setHorizontalTextPosition(JLabel.CENTER); // places text at the center of the JLabel relative to icon
		nameApplication.setVerticalTextPosition(JLabel.BOTTOM); // places text at the bottom of the JLabel relative to icon
		nameApplication.setForeground(new Color(255,50,50)); // sets the text color, type of red
		nameApplication.setFont(new Font("Arial",Font.BOLD,70)); // sets the font of the text and size of the letters
		nameApplication.setBounds(50, 20, 400, 400); // since layout is null sets x and y position and width and length of the JLabel
		
		informationOfApplicaiton = new JLabel();
		informationOfApplicaiton.setText("<html>SuperDude hepls you find friends and gives you a chance to share with all around the world, let's be super dudes.</html>"); // sets the text of the Jlabel
		informationOfApplicaiton.setForeground(new Color(255,50,50)); // sets the text color, type of red
		informationOfApplicaiton.setFont(new Font("Arial",Font.BOLD,18)); // sets the font of the text and size of the letters
		informationOfApplicaiton.setBounds(50, 240, 400, 400); // since layout is null sets x and y position and width and length of the JLabel
		
		
		betweenButtons = new JLabel();
		betweenButtons.setText("-----------------------------"); // sets the text of the Jlabel
		betweenButtons.setForeground(Color.black); // sets the text color, black
		betweenButtons.setFont(new Font("Arial",Font.BOLD,30)); // sets the font of the text and size of the letters
		betweenButtons.setBounds(600,350, 500, 50); // since layout is null sets x and y position and width and length of the JLabel
		
		
		
		loginButton = new JButton("Log In"); // sets the text of the JButton and creates the object
		loginButton.setBounds(600, 300, 300,50);// since layout is null sets x and y position and width and length of the JButton
		loginButton.setFocusable(false); // closes the rectangle shape around the button
		loginButton.addActionListener(this); // adds an ActionLsitener
		loginButton.setBackground(new Color(240,240,0)); // sets the background color of the JButton, type of yellow
		loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
		loginButton.setFont(new Font("Arial",Font.ITALIC,20));// sets the font of the text and size of the letters
		
		signUpButton = new JButton("Create New Account"); // sets the text of the JButton and creates the object
		signUpButton.setBounds(600, 410, 300,50); // since layout is null sets x and y position and width and length of the JButton
		signUpButton.setFocusable(false); // closes the rectangle shape around the button
		signUpButton.addActionListener(this);  // adds an ActionLsitener
		signUpButton.setBackground(new Color(240,240,0));  // sets the background color of the JButton, type of yellow
		signUpButton.setBorder(BorderFactory.createRaisedBevelBorder());
		signUpButton.setFont(new Font("Arial",Font.ITALIC,20)); // sets the font of the text and size of the letters
		
		nickNameEmail = new JTextField(); 
		nickNameEmail.setBounds(600, 130, 300,50);
		nickNameEmail.setFont(new Font("Consolas",Font.PLAIN,18));
		nickNameEmail.setForeground(new Color(240,240,0));
		nickNameEmail.setBackground(Color.black);
		nickNameEmail.setCaretColor(new Color(240,240,0));
		nickNameEmail.setText("Email adress or nickname ");
		nickNameEmail.addKeyListener(this);
		
		
		
		password= new JTextField();
		password.setBounds(600, 190, 300,50);
		password.setFont(new Font("Consolas",Font.PLAIN,18));
		password.setForeground(new Color(240,240,0));
		password.setBackground(Color.black);
		password.setCaretColor(new Color(240,240,0));
		password.setText("Password ");
		password.addKeyListener(this);
		
		entranceFrame = new JFrame("SuperDude | Welcome my super friend :) ");
		entranceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entranceFrame.setIconImage(logoApplication.getImage());
		entranceFrame.setSize(1000, 700);
		entranceFrame.getContentPane().setBackground(new Color(30,30,255));
		entranceFrame.setLayout(null);
		entranceFrame.setFocusable(false);
		
		entranceFrame.add(nameApplication);
		entranceFrame.add(loginButton);
		entranceFrame.add(signUpButton);
		entranceFrame.add(nickNameEmail);
		entranceFrame.add(password);
		entranceFrame.add(betweenButtons);
		entranceFrame.add(informationOfApplicaiton);
		
		entranceFrame.setVisible(true);
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) { // when login button is clicked, checks whether inputs are ass needed(email or nickname, password)
			
			if(User.getNickNamePasswordCombination().containsKey(nickNameEmail.getText()) && User.getNickNamePasswordCombination().get(nickNameEmail.getText()).equals(password.getText())) {
				
				entranceFrame.setVisible(false);
				
				new HomePage(User.getNickNameUserCombination().get(nickNameEmail.getText()));
			}
			
			else if(User.getEmailPasswordCombination().containsKey(nickNameEmail.getText()) && User.getEmailPasswordCombination().get(nickNameEmail.getText()).equals(password.getText())) {
				
				entranceFrame.setVisible(false);
				new HomePage(User.getEmailUserCombination().get(nickNameEmail.getText()));
			}
			
			else if(!(User.getNickNamePasswordCombination().containsKey(nickNameEmail.getText())) && !(User.getEmailPasswordCombination().containsKey(nickNameEmail.getText()))  ) {
				
				JOptionPane.showMessageDialog(entranceFrame,"There is not an account with this email or nickname, please check for misspelling!", "SuperDude | Sorry we cannot let you in :(", JOptionPane.WARNING_MESSAGE);
			}
			else if( User.getEmailPasswordCombination().containsKey(nickNameEmail.getText())  && !(User.getEmailPasswordCombination().get(nickNameEmail.getText()).equals(password.getText())) ) {
				
				JOptionPane.showMessageDialog(entranceFrame,"Wrong password, please check for misspelling!", "SuperDude | Sorry we cannot let you in :(", JOptionPane.WARNING_MESSAGE);
			}
			else if( User.getNickNamePasswordCombination().containsKey(nickNameEmail.getText()) && !(User.getNickNamePasswordCombination().get(nickNameEmail.getText()).equals(password.getText()))) {
				
				JOptionPane.showMessageDialog(entranceFrame,"Wrong password, please check for misspelling!", "SuperDude | Sorry we cannot let you in :(", JOptionPane.WARNING_MESSAGE);

			}
			
			
		}
		else if(e.getSource() == signUpButton) { // when sign up button is clicked creates a new CreateNewAccountPage
			
			
			
			new CreateNewAccountPage();
			
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) { // if user presses a key informative messages from the JTextFiels are deleted
		if(e.getSource()== nickNameEmail && nickNameEmail.getText().equals("Email adress or nickname ") ) {
			
			nickNameEmail.setText(null);
		}
		
		else if(e.getSource()== password && password.getText().equals("Password ") ) {
			
			password.setText(null);
		
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) { // if user releases a key and JTextField is empty, it sets the informative messages again
		
		 if(e.getSource()== nickNameEmail && nickNameEmail.getText().equals("")) {
					
			nickNameEmail.setText("Email adress or nickname ");
					
		}
	
		 
		else if(e.getSource()== password && password.getText().equals("")) {
			
			password.setText("Password ");
			
		}
		 
	}
}
	
