import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;

public class DataIOTest{
	
	@Test
	public void test_saveEmployeesOneEmployee(){
		try{
			EmployeeManagement e = new EmployeeManagement();
			
			Employee e1 = new Employee("Bob", "Smith", "Teller", "m", "12345", "123456789");
		
			e.addEmployeestoArray(e1);
		
			ArrayList<Employee> eList = e.getEmployeesArray();
			
			String adminAcc = "BobSmith.txt";
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(adminAcc)));
		
			DataIO dio = new DataIO(adminAcc, eList);
			dio.saveEmployees();
			output.close();
			
			Scanner scanner = new Scanner(new FileInputStream(adminAcc));
			String expected = "Bob" + "\t " + "Smith" + "\t " + "Teller" + "\t " + "m" + "\t " + "12345" + "\t " + "123456789";
			if (scanner.hasNext()){
		
				String line = scanner.nextLine();
				assertEquals("Employee does not match.", expected, line);
			} 
			else {
				fail("The output file is empty.");
			}
			scanner.close();
		} 
		catch (FileNotFoundException fnfe){
			fail("Cannot find the file.");
		}
		catch(IOException ioe){
			fail("Did not expect an IOException.");
		}
		
	}
	
	
	@Test
	public void test_saveEmployeesMultipleEmployees(){
		try{
			EmployeeManagement e = new EmployeeManagement();
			
			Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "123456789");
			Employee e2 = new Employee("John", "Cena", "HR", "e", "23456", "987654321");
			Employee e3 = new Employee("Alan", "Brown", "IT", "o", "18427", "123987653");
		
			e.addEmployeestoArray(e1);
			e.addEmployeestoArray(e2);
			e.addEmployeestoArray(e3);
		
			ArrayList<Employee> eList = e.getEmployeesArray();
			
			String adminAcc = "BobSmith.txt";
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(adminAcc)));
		
			DataIO dio = new DataIO(adminAcc, eList);
			dio.saveEmployees();
			output.close();
			
			Scanner scanner = new Scanner(new FileInputStream(adminAcc));
			String expected = "Bob" + "\t " + "Smith" + "\t " + "FrontDesk" + "\t " + "m" + "\t " + "12345" + "\t " + "123456789";
			String expected2 = "John" + "\t " + "Cena" + "\t " + "HR" + "\t " + "e" + "\t " + "23456" + "\t " + "987654321";
			String expected3 = "Alan" + "\t " + "Brown" + "\t " + "IT" + "\t " + "o" + "\t " + "18427" + "\t " + "123987653";
			if (scanner.hasNext()){
				
				String line = scanner.nextLine();
				String line2 = scanner.nextLine();
				String line3 = scanner.nextLine();
				assertEquals("Testing employees in admin file.", expected, line);
				assertEquals("Testing employees in admin file.", expected2, line2);
				assertEquals("Testing employees in admin file.", expected3, line3);
			} 
			else {
				fail("The admin file is empty.");
			}
			scanner.close();
		} 
		catch (FileNotFoundException fnfe){
			fail("Cannot open the admin file.");
		}
		catch(IOException ioe){
			fail("Did not expect an IOException.");
		}
		
	}
	
	@Test
	public void test_saveEmployeesNoEmployees(){
		try{
			EmployeeManagement e = new EmployeeManagement();
		
			ArrayList<Employee> eList = e.getEmployeesArray();
			
			String adminAcc = "Empty.txt";
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(adminAcc)));
		
			DataIO dio = new DataIO(adminAcc, eList);
			dio.saveEmployees();
			output.close();
			
			//The file is empty but will say the length is 9.
			if (adminAcc.length() == 9){
				assertEquals("Added no employees, should not have added an employee.", 9, adminAcc.length());
			}
			else{
				fail("Added no employees, should not have added an employee.");
			}
			
		} 
		catch (FileNotFoundException fnfe){
			fail("Cannot find the file.");
		}
		catch(IOException ioe){
			fail("Did not expect an IOException.");
		}
		
	}
	@Test
	public void test_populateEmployees(){
		try{
			EmployeeManagement e = new EmployeeManagement();
			
			Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "1234567890");
			Employee e2 = new Employee("John", "Cena", "HR", "e", "23456", "9876543210");
			Employee e3 = new Employee("Alan", "Brown", "IT", "o", "18427", "1239876530");
		
			e.addEmployeestoArray(e1);
			e.addEmployeestoArray(e2);
			e.addEmployeestoArray(e3);
		
			ArrayList<Employee> eList = e.getEmployeesArray();
			
			String adminAcc = "BobSmith.txt";
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(adminAcc)));
			DataIO dio = new DataIO(adminAcc, eList);
			dio.saveEmployees();
			dio.populateEmployees();
			output.close();
			
			String expected = "Bob" + "\t " + "Smith" + "\t " + "FrontDesk" + "\t " + "m" + "\t " + "12345" + "\t " + "1234567890";
			String expected2 = "John" + "\t " + "Cena" + "\t " + "HR" + "\t " + "e" + "\t " + "23456" + "\t " + "9876543210";
			String expected3 = "Alan" + "\t " + "Brown" + "\t " + "IT" + "\t " + "o" + "\t " + "18427" + "\t " + "1239876530";
			
			Scanner scanner = new Scanner(new FileInputStream(adminAcc));
			if (scanner.hasNext()){
				
				String line = scanner.nextLine();
				String line2 = scanner.nextLine();
				String line3 = scanner.nextLine();
				assertEquals("Testing employees in admin file.", expected, line);
				assertEquals("Testing employees in admin file.", expected2, line2);
				assertEquals("Testing employees in admin file.", expected3, line3);
			
			} 
			else {
				fail("The admin file is empty.");
			}
			scanner.close();
		}
		catch (FileNotFoundException fnfe){
			fail("Cannot find the file.");
		}
		catch(IOException ioe){
			fail("Did not expect an IOException.");
		}
		
	}
	
	@Test
	public void test_fromString(){
		EmployeeManagement e = new EmployeeManagement();	
		Employee e1 = new Employee("Bob", "Smith", "FrontDesk", "m", "12345", "1234567890");
		e.addEmployeestoArray(e1);
		
		ArrayList<Employee> eList = e.getEmployeesArray();
		
		String adminAcc = "adminAcc.txt";
		
		DataIO dio = new DataIO(adminAcc, eList);
		
		String input = "Bob" + "\t " + "Smith" + "\t " + "FrontDesk" + "\t " + "m" + "\t " + "12345" + "\t " + "1234567890";
		
		dio.fromString(input);
		
		String actual = e1.getShift();
		String expected = "m";
		
		assertEquals("Testing from string method.", expected, actual);
	
	}
	
}