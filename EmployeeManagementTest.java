import static org.junit.Assert.*;

import java.io.*;
import org.junit.Test;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
import java.util.ArrayList;

public class EmployeeManagementTest{

	@Test
	public void test_manageLoginNewAdmin() throws IOException {
		EmployeeManagement e = new EmployeeManagement();
		LoginManager lm = new LoginManager();
					
		String adminAcc = "BobSmith";			
		String adminPass = "testPass";
		
		String admin = "BobSmith" + "\t" + "testPass";

		lm.addAdmin(adminAcc, adminPass);

		ArrayList<String> actual = lm.getAdmins();
		assertEquals("Testing new admin.", admin, actual.get(0));
			
	}
	
	@Test
	public void test_manageLoginExistingAdmin() throws IOException {
		EmployeeManagement e = new EmployeeManagement();
		LoginManager lm = new LoginManager();
		String adminAcc = "BobSmith";			
		String adminPass = "testPass";
		
		//lm.addAdmin(adminAcc, adminPass);
		
		boolean actual = lm.checkAdmin(adminAcc, adminPass);
		
		assertEquals("Testing if existing admin exists", true, actual);
		
	}
	
	@Test
	public void test_manageLoginExistingAdminFalse() throws IOException {
		EmployeeManagement e = new EmployeeManagement();
		LoginManager lm = new LoginManager();
		String adminAcc = "BobbySmith";			
		String adminPass = "noPass";
		
		//lm.addAdmin(adminAcc, adminPass);
		
		boolean actual = lm.checkAdmin(adminAcc, adminPass);
		
		assertEquals("Testing if existing admin exists", false, actual);
		
	}
	
	
	@Test
	public void test_addNewEmployee() {
		EmployeeManagement e = new EmployeeManagement();
		Employee eadd = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "123456789");
		String actual = eadd.toString();
		
		String expected = ("Bob" + "\t " + "Smith" + "\t " + "FrontDesk" + "\t " + "m" + "\t " + "12345" + "\t " + "123456789");
		
		assertEquals("Testing adding employee", expected, actual);
	}
	
	@Test
	public void test_printAllEmployees() {
		EmployeeManagement e = new EmployeeManagement();
		Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "123456789");
		Employee e2 = new Employee("John", "Cena", "HR", "e", "23456", "987654321");
		Employee e3 = new Employee("Alan", "Turning", "IT", "o", "18427", "123987653");
		
		e.addEmployeestoArray(e1);
		e.addEmployeestoArray(e2);
		e.addEmployeestoArray(e3);
		
		ArrayList<Employee> actual = e.getEmployeesArray();
		
		ArrayList<String> expected = new ArrayList<String>();
		
		String emInfo1 = ("Bob" + "\t " + "Smith" + "\t " + "FrontDesk" + "\t " + "m" + "\t " + "12345" + "\t " + "123456789");
		String emInfo2 = ("John" + "\t " + "Cena" + "\t " + "HR" + "\t " + "e" + "\t " + "23456" + "\t " + "987654321");
		String emInfo3 = ("Alan" + "\t " + "Turning" + "\t " + "IT" + "\t " + "o" + "\t " + "18427" + "\t " + "123987653");
		
		expected.add(emInfo1);
		expected.add(emInfo2);
		expected.add(emInfo3);
		
		e.printAllEmployees();
		
		assertEquals("Added 3 employees. Array list should contain 3 employees.", 3, actual.size());
		assertEquals("Testing first employee info", expected.get(0) , actual.get(0).toString());
		assertEquals("Testing second employee info", expected.get(1) , actual.get(1).toString());
		assertEquals("Testing third employee info", expected.get(2) , actual.get(2).toString());
		
	}
	
	@Test
	public void test_runCount() {
		EmployeeManagement e = new EmployeeManagement();
		Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "123456789");
		Employee e2 = new Employee("John", "Cena", "HR", "e", "23456", "987654321");
		Employee e3 = new Employee("Alan", "Turning", "IT", "o", "18427", "123987653");
		
		e.addEmployeestoArray(e1);
		e.addEmployeestoArray(e2);
		e.addEmployeestoArray(e3);
		
		ArrayList<Employee> actual = e.getEmployeesArray();
		
		ArrayList<String> expected = new ArrayList<String>();
		
		String emInfo1 = ("Bob" + "\t " + "Smith" + "\t " + "FrontDesk" + "\t " + "m" + "\t " + "12345" + "\t " + "123456789");
		String emInfo2 = ("John" + "\t " + "Cena" + "\t " + "HR" + "\t " + "e" + "\t " + "23456" + "\t " + "987654321");
		String emInfo3 = ("Alan" + "\t " + "Turning" + "\t " + "IT" + "\t " + "o" + "\t " + "18427" + "\t " + "123987653");
		
		expected.add(emInfo1);
		expected.add(emInfo2);
		expected.add(emInfo3);
		
		assertEquals("Added 3 employees. Array list should contain 3 employees.", 3, actual.size());
		
	}
	
	@Test
	public void test_runRemove() {
		EmployeeManagement e = new EmployeeManagement();
		Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "123456789");
		Employee e2 = new Employee("John", "Cena", "HR", "e", "23456", "987654321");
		Employee e3 = new Employee("Alan", "Turning", "IT", "o", "18427", "123987653");
		
		e.addEmployeestoArray(e1);
		e.addEmployeestoArray(e2);
		e.addEmployeestoArray(e3);
		
		ArrayList<Employee> actual = e.getEmployeesArray();
		
		ArrayList<String> expected = new ArrayList<String>();
		
		String emInfo1 = ("Bob" + "\t " + "Smith" + "\t " + "FrontDesk" + "\t " + "m" + "\t " + "12345" + "\t " + "123456789");
		String emInfo2 = ("John" + "\t " + "Cena" + "\t " + "HR" + "\t " + "e" + "\t " + "23456" + "\t " + "987654321");
		String emInfo3 = ("Alan" + "\t " + "Turning" + "\t " + "IT" + "\t " + "o" + "\t " + "18427" + "\t " + "123987653");
		
		expected.add(emInfo1);
		expected.add(emInfo2);
		expected.add(emInfo3);
		expected.remove(emInfo2);
		
		Employee Em = e.searchEmployee("John","Cena");
		actual.remove(Em);
		
		assertEquals("Removed 1 employee. Array should contain 2 employees.", 2, actual.size());
		assertEquals("Testing first employee info", expected.get(0) , actual.get(0).toString());
		assertEquals("Testing second employee info", expected.get(1) , actual.get(1).toString());
	}
	
	@Test
	public void test_runSearch() {
		EmployeeManagement e = new EmployeeManagement();
		Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "123456789");
		Employee e2 = new Employee("John", "Cena", "HR", "e", "23456", "987654321");
		Employee e3 = new Employee("Alan", "Turning", "IT", "o", "18427", "123987653");
		
		e.addEmployeestoArray(e1);
		e.addEmployeestoArray(e2);
		e.addEmployeestoArray(e3);
		
		ArrayList<Employee> actual = e.getEmployeesArray();
		
		ArrayList<String> expected = new ArrayList<String>();
		
		String emInfo1 = ("Bob" + "\t " + "Smith" + "\t " + "FrontDesk" + "\t " + "m" + "\t " + "12345" + "\t " + "123456789");
		String emInfo2 = ("John" + "\t " + "Cena" + "\t " + "HR" + "\t " + "e" + "\t " + "23456" + "\t " + "987654321");
		String emInfo3 = ("Alan" + "\t " + "Turning" + "\t " + "IT" + "\t " + "o" + "\t " + "18427" + "\t " + "123987653");
		
		expected.add(emInfo1);
		expected.add(emInfo2);
		expected.add(emInfo3);
		
		Employee Em = e.searchEmployee("John","Cena");
		String em = Em.toString();

		assertEquals("Testing search function.", em, actual.get(1).toString());
	}
	
	@Test
	public void test_runAvail() {
		EmployeeManagement e = new EmployeeManagement();
		Schudule s = new Schudule();
		Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "123456789");
		Employee e2 = new Employee("John", "Cena", "HR", "e", "23456", "987654321");
		Employee e3 = new Employee("Alan", "Turning", "IT", "o", "18427", "123987653");
		
		e.addEmployeestoArray(e1);
		e.addEmployeestoArray(e2);
		e.addEmployeestoArray(e3);
		
		ArrayList<Employee> actual = e.getEmployeesArray();
		
		ArrayList<String> expected = new ArrayList<String>();
		
		String emInfo1 = ("Bob" + "\t " + "Smith" + "\t " + "FrontDesk" + "\t " + "m" + "\t " + "12345" + "\t " + "123456789");
		String emInfo2 = ("John" + "\t " + "Cena" + "\t " + "HR" + "\t " + "e" + "\t " + "23456" + "\t " + "987654321");
		String emInfo3 = ("Alan" + "\t " + "Turning" + "\t " + "IT" + "\t " + "o" + "\t " + "18427" + "\t " + "123987653");
		
		expected.add(emInfo1);
		expected.add(emInfo2);
		expected.add(emInfo3);
		
		Employee Em = e.searchEmployee("John","Cena");
		String em = Em.toString();
		boolean working = s.isWorking(Em);
		assertEquals("Testing available function.", false, working);
	}
	
	// private void assertFileContent(String message, String[] expectedLinesInFile, String filename) {
		// try {
            // BufferedReader input = new BufferedReader(new FileReader(filename));
            // int index = 0;
			// String line = input.readLine();
			// while (line != null) {
				// if (index >= expectedLinesInFile.length) {
					// fail(message + " Found more lines in file than expected.  Only expected " + expectedLinesInFile.length + " lines");
				// }
				// assertEquals(message + " testing line " + index + " in output file", expectedLinesInFile[index], line);
				// line = input.readLine();
				// index++;
			// }
			// assertEquals(message + " Expected more lines in output file.", expectedLinesInFile.length, index);
			// input.close();
		// } catch (IOException ioe) {
			// fail("Unexpected exception when testing file content.");
		// }		
	// }
	
}