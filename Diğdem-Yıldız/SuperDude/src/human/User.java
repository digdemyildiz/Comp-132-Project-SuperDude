package human;

import java.util.HashMap;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class User {
	private String accountType; 
	private String nickname;
	private String emailAdress;
	private String password;
	private String realName;
	private String realSurname;
	private String gender;
	private int age;
	private ImageIcon profilePhoto;
	private HashSet<String> hobbies = new HashSet<>();
	private HashSet<Group> joinedGroups = new HashSet<>();
	private HashMap<String,User> friends = new HashMap<>();
	
	private HashMap<String,JPanel> contents = new HashMap<>();
	
	



	private static HashMap<String,String> nickNamePasswordCombination = new HashMap<>(); // holds passwords with their associated nick names
	private static HashMap<String,String> emailPasswordCombination = new HashMap<>(); // holds passwords with their associated email adresses
	private static HashMap<String,User> nickNameUserCombination = new HashMap<>(); // holds current users with their associated nick names
	private static HashMap<String,User> emailUserCombination = new HashMap<>(); // holds current users with their associated email adresses
	
	private static HashSet<User> allUsers = new HashSet<>(); // holds all current users of the application
	
	
	
	
	
	
	public User(String accountType, String nickname, String emailAdress, String password, String realName, String realSurname,
			String gender, int age, ImageIcon profilePhoto, HashSet<String> hobbies) {
		
		
		this.accountType = accountType ;
		this.nickname = nickname;
		this.emailAdress = emailAdress;
		this.password = password;
		this.realName = realName;
		this.realSurname = realSurname;
		this.gender = gender;
		this.age = age;
		this.profilePhoto = profilePhoto;
	
		
		nickNamePasswordCombination.put(nickname, password);
		emailPasswordCombination.put(emailAdress, password);
		nickNameUserCombination.put(nickname, this);
		emailUserCombination.put(emailAdress, this);
		
		allUsers.add(this);
		
	}
	
	public void follow(User u) { //  its parameter is a User, it takes a user to follow, does not return anything
		
		friends.put(u.getNickname(), u); // places the user u to the friends list of this user
		u.getFriends().put(nickname, this); // places this user to the friends list of user u
	} 
	
	public void unfollow(User u) { //  its parameter is a User, it takes a user to unfollow, does not return anything
			
		friends.remove(u.getNickname()); // removes the user u from the friends list of this user
		u.getFriends().remove(nickname); // removes this user from the friends list of user u
	}
	
	public static void deleteUser(User u) { //  its parameter is a User, it takes a user to follow, does not return anything
		
		 nickNamePasswordCombination.remove(u.getNickname()); // removes the password of u from the map that associates passwords with their related nicknames
		 
		 emailPasswordCombination.remove(u.getEmailAdress()); // removes the password of u from the map that associates passwords with their related email adresses
		 
		 nickNameUserCombination.remove(u.getNickname());  // removes the user u from the map that associates users with their related nicknames
		 
		 emailUserCombination.remove(u.getEmailAdress());  // removes the user u from the map that associates users with their related email adresses
			
		 allUsers.remove(u); // removes user u from a set where all users of the applicaiton exists
		 
	}



	public HashMap<String, JPanel> getContents() {
		return contents;
	}

	public void setContents(HashMap<String, JPanel> contents) {
		this.contents = contents;
	}
	
	public HashMap<String, User> getFriends() {
		return friends;
	}

	public void setFriends(HashMap<String, User> friends) {
		this.friends = friends;
	}

	public static HashMap<String, User> getNickNameUserCombination() {
		return nickNameUserCombination;
	}



	public static void setNickNameUserCombination(HashMap<String, User> nickNameUserCombination) {
		User.nickNameUserCombination = nickNameUserCombination;
	}



	public static HashMap<String, User> getEmailUserCombination() {
		return emailUserCombination;
	}



	public static void setEmailUserCombination(HashMap<String, User> emailUserCombination) {
		User.emailUserCombination = emailUserCombination;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getEmailAdress() {
		return emailAdress;
	}



	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRealName() {
		return realName;
	}



	public void setRealName(String realName) {
		this.realName = realName;
	}



	public String getRealSurname() {
		return realSurname;
	}



	public void setRealSurname(String realSurname) {
		this.realSurname = realSurname;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public ImageIcon getProfilePhoto() {
		return profilePhoto;
	}



	public void setProfilePhoto(ImageIcon profilePhoto) {
		this.profilePhoto = profilePhoto;
	}



	public HashSet<String> getHobbies() {
		return hobbies;
	}



	public void setHobbies(HashSet<String> hobbies) {
		this.hobbies = hobbies;
	}



	public HashSet<Group> getJoinedGroups() {
		return joinedGroups;
	}



	public void setJoinedGroups(HashSet<Group> joinedGroups) {
		this.joinedGroups = joinedGroups;
	}



	public static HashMap<String, String> getNickNamePasswordCombination() {
		return nickNamePasswordCombination;
	}



	public static void setNickNamePasswordCombination(HashMap<String, String> nickNamePasswordCombination) {
		User.nickNamePasswordCombination = nickNamePasswordCombination;
	}



	public static HashMap<String, String> getEmailPasswordCombination() {
		return emailPasswordCombination;
	}



	public static void setEmailPasswordCombination(HashMap<String, String> emailPasswordCombination) {
		User.emailPasswordCombination = emailPasswordCombination;
	}



	public static HashSet<User> getAllUsers() {
		return allUsers;
	}



	public static void setAllUsers(HashSet<User> allUsers) {
		User.allUsers = allUsers;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	
	
	
	
	
	
	
}
