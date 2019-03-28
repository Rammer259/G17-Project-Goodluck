import static org.junit.Assert.*;

import java.io.*;
import org.junit.Test;

public class SchuduleTest{
	
	
	@Test
	public void test_isWorking(){
		
		Schudule s = new Schudule();
		Employee e = new Employee("Bob", "Smith", "Marketing", "m", "55555", "123456789");
		
		boolean actual = s.isWorking(e);
		
		assertEquals("Checking if employee is working.", false, actual);
	}
	
}