package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import human.User;

public class CreateNewAccountPage extends JFrame implements ActionListener,KeyListener {
	
	private JTextField realName;
	private JTextField realSurname;
	private JTextField emailAdress;
	private JTextField nickname;
	private JTextArea hobbies;
	private JTextField password;
	private JTextField passwordConfirmation;
	private JTextField age;
	
	private JRadioButton female;
	private JRadioButton male;
	private JRadioButton none;
	
	private JRadioButton premium;
	private JRadioButton standard;
	
	private JButton finish;
	private JButton selectPhoto;
	
	private JLabel profilePhotoSelect;
	private JLabel genderSelect;
	private JLabel accountSelect;
	private JLabel hobbiesSelect;
	
	private JLabel nameApplication;
	
	private ImageIcon selectedPhoto = null;
	private String gender;
	private HashSet<String> hobbySet;
	
	public CreateNewAccountPage(){
		
		nameApplication = new JLabel();
		nameApplication.setText("SuperDude");
		nameApplication.setForeground(new Color(255,50,50));
		nameApplication.setFont(new Font("Arial",Font.BOLD,70));
		nameApplication.setBounds(300, 20, 400, 80);
		
		
		realName = new JTextField();
		realName.setFont(new Font("Consolas",Font.PLAIN,18));
		realName.setForeground(new Color(240,240,0));
		realName.setBackground(Color.black);
		realName.setCaretColor(new Color(240,240,0));
		realName.setText("First name ");
		realName.setBounds(60,160,300,50);
		realName.addKeyListener(this);
		
		realSurname = new JTextField();
		realSurname.setFont(new Font("Consolas",Font.PLAIN,18));
		realSurname.setForeground(new Color(240,240,0));
		realSurname.setBackground(Color.black);
		realSurname.setCaretColor(new Color(240,240,0));
		realSurname.setText("Surname ");
		realSurname.setBounds(60,230,300,50);
		realSurname.addKeyListener(this);
		
		emailAdress = new JTextField();
		emailAdress.setFont(new Font("Consolas",Font.PLAIN,18));
		emailAdress.setForeground(new Color(240,240,0));
		emailAdress.setBackground(Color.black);
		emailAdress.setCaretColor(new Color(240,240,0));
		emailAdress.setText("Email adress ");
		emailAdress.setBounds(60,300,300,50);
		emailAdress.addKeyListener(this);
		
		nickname = new JTextField();
		nickname.setFont(new Font("Consolas",Font.PLAIN,18));
		nickname.setForeground(new Color(240,240,0));
		nickname.setBackground(Color.black);
		nickname.setCaretColor(new Color(240,240,0));
		nickname.setText("Nickname ");
		nickname.setBounds(60, 370,300, 50);
		nickname.addKeyListener(this);
		
		
		age = new JTextField();
		age.setFont(new Font("Consolas",Font.PLAIN,18));
		age.setForeground(new Color(240,240,0));
		age.setBackground(Color.black);
		age.setCaretColor(new Color(240,240,0));
		age.setText("Age ");
		age.setBounds(60, 440,300, 50);
		age.addKeyListener(this);
		
		password = new JTextField();
		password.setFont(new Font("Consolas",Font.PLAIN,18));
		password.setForeground(new Color(240,240,0));
		password.setBackground(Color.black);
		password.setCaretColor(new Color(240,240,0));
		password.setText("Password ");
		password.setBounds(60, 510,300, 50);
		password.addKeyListener(this);
		
		passwordConfirmation = new JTextField();
		passwordConfirmation.setFont(new Font("Consolas",Font.PLAIN,18));
		passwordConfirmation.setForeground(new Color(240,240,0));
		passwordConfirmation.setBackground(Color.black);
		passwordConfirmation.setCaretColor(new Color(240,240,0));
		passwordConfirmation.setText("Password confirmation ");
		passwordConfirmation.setBounds(60, 580,300, 50);
		passwordConfirmation.addKeyListener(this);
		
		
		

		hobbies = new JTextArea();
		hobbies.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		hobbies.setFont(new Font("Consolas",Font.PLAIN,18));
		hobbies.setForeground(new Color(240,240,0));
		hobbies.setBackground(Color.black);
		hobbies.setCaretColor(new Color(240,240,0));
		hobbies.setText("Example: swimming, walking, \n(seperate with comma!)");
		hobbies.setBounds(520,420,390,210);
		hobbies.addKeyListener(this);

		
		ButtonGroup genders = new ButtonGroup();
		
		female = new JRadioButton("Female");
		female.setFocusable(false);
		female.setForeground(Color.black);
		female.setBackground(new Color(240,240,0));
		female.setFont(new Font("Consolas",Font.ITALIC,18));
		female.setBounds(520, 270 , 100, 30);
	
		
		
		
		male = new JRadioButton("Male");
		male.setFocusable(false);
		male.setForeground(Color.black);
		male.setBackground(new Color(240,240,0));
		male.setFont(new Font("Consolas",Font.ITALIC,18));
		male.setBounds(640, 270 , 100, 30);
		
		none = new JRadioButton("None");
		none.setFocusable(false);
		none.setForeground(Color.black);
		none.setBackground(new Color(240,240,0));
		none.setFont(new Font("Consolas",Font.ITALIC,18));
		none.setBounds(760, 270 , 100, 30);
		
		
		
		genders.add(female);
		genders.add(male);
		genders.add(none);

		ButtonGroup accountType = new ButtonGroup();
				
		premium = new JRadioButton("Premium");
		premium.setFocusable(false);
		premium.setForeground(Color.black);
		premium.setBackground(new Color(240,240,0));
		premium.setFont(new Font("Consolas",Font.ITALIC,18));
		premium.setBounds(520, 345 , 130, 30);
		
		standard = new JRadioButton("Standard");
		standard.setFocusable(false);
		standard.setForeground(Color.black);
		standard.setBackground(new Color(240,240,0));
		standard.setFont(new Font("Consolas",Font.ITALIC,18));
		standard.setBounds(670, 345 , 130, 30);
		
		accountType.add(premium);
		accountType.add(standard);
		
		finish = new JButton("FINISH");
		finish.setBounds(600, 300, 300,50);
		finish.setFocusable(false);
		finish.setForeground(Color.black);
		finish.setBackground(new Color(240,240,0));
		finish.setBorder(BorderFactory.createRaisedBevelBorder());
		finish.setFont(new Font("Consolas",Font.ITALIC,25));
		finish.setBounds(60, 660, 850, 60);
		finish.addActionListener(this);
		
		
		selectPhoto = new JButton("Select photo");
		selectPhoto.setBounds(600, 300, 300,50);
		selectPhoto.setFocusable(false);
		selectPhoto.setForeground(Color.black);
		selectPhoto.setBackground(new Color(240,240,0));
		selectPhoto.setBorder(BorderFactory.createRaisedBevelBorder());
		selectPhoto.setFont(new Font("Consolas",Font.ITALIC,18));
		selectPhoto.setBounds(520, 190, 200,35);
		selectPhoto.addActionListener(this);
		
		
		profilePhotoSelect = new JLabel();
		profilePhotoSelect.setText("Profile photo (optional)");
		profilePhotoSelect.setForeground(Color.black);
		profilePhotoSelect.setFont(new Font("Consolas",Font.BOLD,20));
		profilePhotoSelect.setBounds(520, 145, 300, 50);
		
		
		genderSelect= new JLabel();
		genderSelect.setText("Gender");
		genderSelect.setForeground(Color.black);
		genderSelect.setFont(new Font("Consolas",Font.BOLD,20));
		genderSelect.setBounds(520, 225, 300, 50);
		
		accountSelect= new JLabel();
		accountSelect.setText("Account type");
		accountSelect.setForeground(Color.black);
		accountSelect.setFont(new Font("Consolas",Font.BOLD,20));
		accountSelect.setBounds(520, 300, 300, 50);
		
		hobbiesSelect= new JLabel();
		hobbiesSelect.setText("Hobbies (optional)");
		hobbiesSelect.setForeground(Color.black);
		hobbiesSelect.setFont(new Font("Consolas",Font.BOLD,20));
		hobbiesSelect.setBounds(520, 375, 300, 50);
		
		
		
		
		
		
		this.setTitle("SuperDude | First and last step to be a Kyrptonian :) ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 800);
		this.getContentPane().setBackground(new Color(30,30,255));
		this.setIconImage((new ImageIcon("superman-logo.png")).getImage());
		this.setLayout(null);
		this.setVisible(true);
		this.setFocusable(false);
		
		this.add(nameApplication);
		this.add(realName);
		this.add(realSurname);
		this.add(emailAdress);
		this.add(nickname);
		this.add(password);
		this.add(passwordConfirmation);
		this.add(age);
		this.add(profilePhotoSelect);
		this.add(selectPhoto);
		this.add(genderSelect);
		this.add(female);
		this.add(male);
		this.add(none);
		this.add(accountSelect);
		this.add(premium);
		this.add(standard);
		this.add(hobbiesSelect);
		this.add(hobbies);
		this.add(finish);
	
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
	}



	@Override
	public void keyPressed(KeyEvent e) { // if user presses a key informative messages from the JTextFiels are deleted
		
		if( e.getSource() == realName && realName.getText().equals("First name ") ){
				
			
			realName.setText(null);
		}
		
		else if( e.getSource() == realSurname && realSurname.getText().equals("Surname ")) {
			
			realSurname.setText(null);
		}
		
		else if( e.getSource() == emailAdress && emailAdress.getText().equals("Email adress ")) {
					
			emailAdress.setText(null);
		}
		
		else if( e.getSource() == nickname && nickname.getText().equals("Nickname ")) {
			
			nickname.setText(null);
		}
		
		else if( e.getSource() == password && password.getText().equals("Password ")) {
			
			password.setText(null);
		}
		
		else if( e.getSource() == passwordConfirmation && passwordConfirmation.getText().equals( "Password confirmation ")) {
			
			passwordConfirmation.setText(null);
		}
		
		else if( e.getSource() == age && age.getText().equals("Age ")) {
			
			age.setText(null);
		}
		else if(e.getSource() == hobbies && hobbies.getText().equals("Example: swimming, walking, \n(seperate with comma!)")){
			
			hobbies.setText(null);
		}
		
	
	}



	@Override
	public void keyReleased(KeyEvent e) { // if user releases a key and JTextField is empty, it sets the informative messages again
		
		if( e.getSource() == realName && realName.getText().equals("") ){
				
			
			realName.setText("First name ");
		}
		
		else if( e.getSource() == realSurname && realSurname.getText().equals("")) {
			
			realSurname.setText("Surname ");
		}
		
		else if( e.getSource() == emailAdress && emailAdress.getText().equals("")) {
					
			emailAdress.setText("Email adress ");
		}
		
		else if( e.getSource() == nickname && nickname.getText().equals("")) {
			
			nickname.setText("Nickname ");
		}
		
		else if( e.getSource() == password && password.getText().equals("")) {
			
			password.setText("Password ");
		}
		
		else if( e.getSource() == passwordConfirmation && passwordConfirmation.getText().equals("")) {
			
			passwordConfirmation.setText("Password confirmation ");
		}
		
		else if( e.getSource() == age && age.getText().equals("")) {
			
			age.setText("Age ");
		}
		else if(e.getSource() == hobbies && hobbies.getText().equals("")) {
			
			hobbies.setText("Example: swimming, walking, \n(seperate with comma!)");
		}
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == selectPhoto) { 
			
			FileFilter imageFilter = new FileNameExtensionFilter("png","PNG","JPEG","jpeg","GIF","gif","JPG","jpg");
			JFileChooser photoChooser = new JFileChooser();
			photoChooser.setDialogTitle("Choose a profile photo");
			photoChooser.setFocusable(false);
			photoChooser.setFileFilter(imageFilter);
			
			int response = photoChooser.showOpenDialog(this);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				
				selectedPhoto = new ImageIcon(photoChooser.getSelectedFile().getAbsolutePath());
			}
			
			
		}
		
		else if(e.getSource() == finish) {
			
			if(realName.getText().equals("First name ") || realName.getText().equals("") ) {
				
				JOptionPane.showMessageDialog(this ,"You must enter a name!","Name is required!", JOptionPane.ERROR_MESSAGE);
				
			}
			
			else if( realSurname.getText().equals("Surname " ) || realSurname.getText().equals("") ) {
				
				JOptionPane.showMessageDialog(this ,"You must enter a surname!","Surname is required!", JOptionPane.ERROR_MESSAGE);
				
			}
			else if( emailAdress.getText().equals("Email adress ")  || emailAdress.getText().equals("")) {
				
				JOptionPane.showMessageDialog(this ,"You must enter an email adress!","Email adress is required!", JOptionPane.ERROR_MESSAGE);
				
				
			}
			else if(nickname.getText().equals("Nickname ")  || nickname.getText().equals("") ) {
				
				JOptionPane.showMessageDialog(this ,"You must enter a nickname!","Nickname is required!", JOptionPane.ERROR_MESSAGE);
				
			}
			
			else if(age.getText().equals("Age ")  || age.getText().equals("")) {
				
				JOptionPane.showMessageDialog(this ,"You must enter your age!","Age is required!", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(password.getText().equals("Password ")  || password.getText().equals("")) {
				
				JOptionPane.showMessageDialog(this ,"You must enter a password!","Password is required!", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(passwordConfirmation.getText().equals("Password confirmation ")  || passwordConfirmation.getText().equals("")) {
				
				JOptionPane.showMessageDialog(this ,"You must confirm your password!","Password for confirmation is required!", JOptionPane.ERROR_MESSAGE);
			}
			
			
			else if (User.getNickNamePasswordCombination().containsKey(nickname.getText())) {
				
				JOptionPane.showMessageDialog(this ,"This nickname is already taken!","Nickname", JOptionPane.ERROR_MESSAGE);
			}
			else if(User.getEmailPasswordCombination().containsKey(emailAdress.getText())) {
				
				JOptionPane.showMessageDialog(this ,"There is already an account with this email adress!","Email adress", JOptionPane.ERROR_MESSAGE);
			}
			else if(!(password.getText().equals(passwordConfirmation.getText()))) {
				
				JOptionPane.showMessageDialog(this ,"Passwords must match!","Password confirmation", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(!(premium.isSelected()) && !(standard.isSelected())) {
				
				JOptionPane.showMessageDialog(this ,"Account type must be declared!","Account type", JOptionPane.ERROR_MESSAGE);
				
			}
			else {
				
				String accountType;
				
				try {
					int age = Integer.parseInt(this.age.getText());
					
					try {
						
						 selectedPhoto.getImage();
						
						
						
					}
					catch(NullPointerException n) {
						
						if(female.isSelected()) {
							gender = "female";
							selectedPhoto = new ImageIcon("Supergirl.PNG");
						}
						else if(male.isSelected()) {
							gender = "male";
							selectedPhoto = new ImageIcon("Superman.png");
						}
						else {
							gender = "none";
							selectedPhoto = new ImageIcon("superman-logo.png");
						}
					}
					
					if(premium.isSelected()) {
						
						accountType = "Premium";
						
					}
					else{
						
						accountType = "Standard";
					}
					
				hobbySet = new HashSet<String>(Arrays.asList(hobbies.getText().split(",")));
				
				User newUser = new User(accountType, nickname.getText(),emailAdress.getText(),password.getText(),realName.getText(),realSurname.getText(),gender,
					age, selectedPhoto, hobbySet);
				
				
				
				JOptionPane.showMessageDialog(this, "Succesfully signed up! You can start using SuperDude!", "Welcome new Kyrptonian :)", JOptionPane.PLAIN_MESSAGE);
				
				this.dispose();
				
					
				}
				catch(NumberFormatException n){
					
					JOptionPane.showMessageDialog(this ,"Your age must be an integer value!","Age format is wrong!", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			
		}
		
	}

}
