import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import org.junit.Test;
import java.util.ArrayList;
import java.time.LocalTime;

public class EmployeeManagementTest{

	@Test
	public void test_manageLoginNewAdmin() throws IOException {
		EmployeeManagement e = new EmployeeManagement();
		LoginManager lm = new LoginManager();
					
		String adminAcc = "BobSmith";			
		String adminPass = "testPass";
	
		String admin = "BobSmith" + "\t" + "testPass";

		lm.addAdmin(adminAcc, adminPass);
		//Scanner scanner = new Scanner(new FileInputStream(adminAcc + ".txt"));
		// if(scanner.hasNext()){
			// String line = scanner.nextLine();
			// assertEquals("Checking if admin was added to admin file.", admin, line);
		// }
		ArrayList<String> actual = lm.getAdmins();
		assertEquals("Testing new admin.", admin, actual.get(0));
			
	}
	
	@Test
	public void test_manageLoginExistingAdminTrue() throws IOException {
		EmployeeManagement e = new EmployeeManagement();
		LoginManager lm = new LoginManager();
		String adminAcc = "BobSmith";
		String adminPass = "testPass";
		lm.addAdmin(adminAcc, adminPass);
		boolean actual = lm.checkAdmin(adminAcc, adminPass);
		
		assertEquals("Testing if existing admin exists", true, actual);
		
	}
	
	@Test
	public void test_manageLoginExistingAdminFalse() throws IOException {
		EmployeeManagement e = new EmployeeManagement();
		LoginManager lm = new LoginManager();
		String adminAcc = "BobbySmith";			
		String adminPass = "noPass";
		lm.addAdmin(adminAcc, "PassNo");
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
		Employee e3 = new Employee("Alan", "Turn", "IT", "o", "18427", "123987653");
		
		e.addEmployeestoArray(e1);
		e.addEmployeestoArray(e2);
		e.addEmployeestoArray(e3);
		
		ArrayList<Employee> actual = e.getEmployeesArray();
		
		ArrayList<String> expected = new ArrayList<String>();
		
		String emInfo1 = ("Bob" + "\t " + "Smith" + "\t " + "FrontDesk" + "\t " + "m" + "\t " + "12345" + "\t " + "123456789");
		String emInfo2 = ("John" + "\t " + "Cena" + "\t " + "HR" + "\t " + "e" + "\t " + "23456" + "\t " + "987654321");
		String emInfo3 = ("Alan" + "\t " + "Turn" + "\t " + "IT" + "\t " + "o" + "\t " + "18427" + "\t " + "123987653");
		
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
	public void test_runRemoveEmployeeNotFound() {
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
		
		Employee Em = e.searchEmployee("John","Smith");
		actual.remove(Em);
		
		assertEquals("Tried to remove an employee who does not exist. Employee list should remain the same", 3, actual.size());
		assertEquals("Testing first employee info", expected.get(0) , actual.get(0).toString());
		assertEquals("Testing second employee info", expected.get(1) , actual.get(1).toString());
		assertEquals("Testing third employee info", expected.get(2) , actual.get(2).toString());
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
	public void test_runAvailEvening() {
		EmployeeManagement e = new EmployeeManagement();
		Schedule s = new Schedule();
		Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "123456789");
		Employee e2 = new Employee("John", "Cena", "HR", "e", "23456", "987654321");
		Employee e3 = new Employee("Alan", "Turning", "IT", "o", "18427", "123987653");
		
		LocalTime startMorning = LocalTime.parse("08:00");
		LocalTime startEvening = LocalTime.parse("16:00");
		LocalTime startOvernight = LocalTime.parse("00:00");
		
		LocalTime local = LocalTime.now();
		
		e.addEmployeestoArray(e1);
		e.addEmployeestoArray(e2);
		e.addEmployeestoArray(e3);
		
		ArrayList<Employee> emps = e.getEmployeesArray();
		
		Employee Em = e.searchEmployee("John","Cena");
		String em = Em.toString();
		boolean working = s.isWorking(Em);
		boolean expected = s.isBetween(local, startEvening, startOvernight);
		assertEquals("Testing available function.", expected, working);
	}
	
	@Test
	public void test_runAvailMorning() {
		EmployeeManagement e = new EmployeeManagement();
		Schedule s = new Schedule();
		Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "123456789");
		Employee e2 = new Employee("John", "Cena", "HR", "e", "23456", "987654321");
		Employee e3 = new Employee("Alan", "Turning", "IT", "o", "18427", "123987653");
		
		LocalTime startMorning = LocalTime.parse("08:00");
		LocalTime startEvening = LocalTime.parse("16:00");
		LocalTime startOvernight = LocalTime.parse("00:00");
		
		LocalTime local = LocalTime.now();
		
		e.addEmployeestoArray(e1);
		e.addEmployeestoArray(e2);
		e.addEmployeestoArray(e3);
		
		ArrayList<Employee> emps = e.getEmployeesArray();
		
		Employee Em = e.searchEmployee("Bob","Smith");
		String em = Em.toString();
		boolean working = s.isWorking(Em);
		boolean expected = s.isBetween(local, startMorning, startEvening);
		assertEquals("Testing available function.", expected, working);
	}
	
	@Test
	public void test_runAvailOvernight() {
		EmployeeManagement e = new EmployeeManagement();
		Schedule s = new Schedule();
		Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "123456789");
		Employee e2 = new Employee("John", "Cena", "HR", "e", "23456", "987654321");
		Employee e3 = new Employee("Alan", "Turning", "IT", "o", "18427", "123987653");
		
		LocalTime startMorning = LocalTime.parse("08:00");
		LocalTime startEvening = LocalTime.parse("16:00");
		LocalTime startOvernight = LocalTime.parse("00:00");
		
		LocalTime local = LocalTime.now();
		
		e.addEmployeestoArray(e1);
		e.addEmployeestoArray(e2);
		e.addEmployeestoArray(e3);
		
		ArrayList<Employee> emps = e.getEmployeesArray();
		
		Employee Em = e.searchEmployee("Alan","Turning");
		String em = Em.toString();
		boolean working = s.isWorking(Em);
		boolean expected = s.isBetween(local, startOvernight, startMorning);
		assertEquals("Testing available function.", expected, working);
	}
	
}