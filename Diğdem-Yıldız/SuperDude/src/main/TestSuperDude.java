package main;

import java.util.HashSet;

import javax.swing.ImageIcon;

import human.User;
import pages.EntrancePage;
import pages.HomePage;
import pages.ProfilePage;

/* Pledge of Honor *************************************************************************************
I hereby certify that I have completed this programming project on my own without any help from
anyone else. The effort in the project thus belongs completely to me. I did not search for a
solution, or I did not consult to any program written by others or did not copy any program from
other sources. I read and followed the guidelines provided in the project description.

READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID

SIGNATURE: <Digdem Yildiz, 72301>
************************************************************************************************************/


public class TestSuperDude {

	public static void main(String[] args) {
		
		
		 User user1 = new User("Premium","kavun" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","female",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user2 = new User("Standard","kavun2" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","male",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user3 = new User("Premium","kavun3" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","woman",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user4 = new User("Standard","kavun4" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","woman",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user5 = new User("Premium","kavun5" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","woman",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user6 = new User("Standard","kavun6" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","woman",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user7 = new User("Premium","kavun7" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","woman",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user8 = new User("Premium","kavun8" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","woman",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user9 = new User("Standard","kavun9" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","woman",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user10 = new User("Premium","kavun10" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","woman",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user11 = new User("Standard","kavun11" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","woman",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 User user12 = new User("Premium","kavun12" , "elma123@hotmail.com", "11111","Diðdem","Yýldýz","woman",20,new ImageIcon("superman-logo.png"), new HashSet<String>());
		 
		 
		 user2.follow(user1);
		 
		 user3.follow(user1);
		 user1.follow(user3);
		 user1.follow(user2);
		 
		// new ProfilePage(user1,user2,new HomePage(user1));
		//new ProfilePage(user1,user8,new HomePage(user1));
		//new HomePage(user1);
		EntrancePage home = new EntrancePage();
	}

}
