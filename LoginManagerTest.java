import static org.junit.Assert.*;

import java.io.*;
import org.junit.Test;
import java.util.ArrayList;

public class LoginManagerTest{
	
	@Test
	public void test_addAdmin(){
		
		LoginManager lm = new LoginManager();
		
		lm.addAdmin("John", "Doe");
		
		ArrayList<String> expected = new ArrayList<String>();
		
		expected.add("John" + "\t" + "Doe");
		
		assertEquals("Added 1 admin.", expected, lm.getAdmins()); 
	
	}
	
	@Test
	public void test_getAdmins(){
		
		LoginManager lm = new LoginManager();
		
		lm.addAdmin("John", "Doe");
		lm.addAdmin("Test", "Admin");
		lm.addAdmin("Victor", "Wake");
		
		ArrayList<String> expected = new ArrayList<String>();
		
		expected.add("John" + "\t" + "Doe");
		expected.add("Test" + "\t" + "Admin");
		expected.add("Victor" + "\t" + "Wake");
		
		assertEquals("Adding 3 admins.", 3, lm.getAdmins().size());
		assertEquals("Testing first admin.", expected.get(0), lm.getAdmins().get(0));
		assertEquals("Testing second admin.", expected.get(1), lm.getAdmins().get(1));
		assertEquals("Testing third admin.", expected.get(2), lm.getAdmins().get(2));
	}
	
	@Test
	public void test_checkAdmin(){
		
		LoginManager lm = new LoginManager();
		
		lm.addAdmin("John", "Doe");
		boolean actual = lm.checkAdmin("John", "Doe");
		
		boolean expected = true;
		
		assertEquals("Checking admin.", expected, actual);
		
	}
	
	@Test
	public void test_checkAdminFalse(){
		
		LoginManager lm = new LoginManager();
		
		lm.addAdmin("John", "Doe");
		boolean actual = lm.checkAdmin("John", "Cena");
		
		boolean expected = false;
		
		assertEquals("Checking admin.", expected, actual);
		
	}

}