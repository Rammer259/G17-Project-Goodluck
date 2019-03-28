import static org.junit.Assert.*;

import java.io.*;
import org.junit.Test;

public class EmployeeTest{

	@Test
	public void test_EmployeeConstructor(){
		Employee e = new Employee("Bob", "Smith", "Marketing", "m", "55555", "123456789");
		
		assertEquals("Testing default constructor. Testing first name.", "Bob", e.getFirstName());
		assertEquals("Testing default constructor. Testing last name.", "Smith", e.getLastName());
		assertEquals("Testing default constructor. Testing shift.", "m", e.getShift());
		
	}
	
	@Test
	public void test_toString(){
		Employee e = new Employee("Bob", "Smith", "Marketing", "e", "55551", "123456791");
		
		String expected =  "Bob" + "\t " + "Smith" + "\t " + "Marketing" + "\t " + "e" + "\t " + "55551" + "\t " + "123456791";
		
		assertEquals("Testing toString.", expected, e.toString());
	}

	@Test
	public void test_getFirstName(){
		Employee e = new Employee("Bob", "Smith", "Marketing", "m", "55555", "123456789");
		
		String expected = "Bob";
		
		assertEquals("Getting first name.", expected, e.getFirstName());
	}
	
	@Test
	public void test_getLastName(){
		Employee e = new Employee("Bob", "Smith", "Marketing", "m", "55555", "123456789");
		
		String expected = "Smith";
		
		assertEquals("Getting last name.", expected, e.getLastName());
	}
	
	@Test
	public void test_getShift(){
		Employee e = new Employee("Bob", "Smith", "Marketing", "m", "55555", "123456789");
		
		String expected = "m";
		
		assertEquals("Getting shift.", expected, e.getShift());
	}
}