import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Employee extends EmployeeManagement{
	
	/**
	*
	*Instance variables for new employees.
	*
	**/

	private String name;
	private String filename;
 	private String title = "employee";
	private double salary = 12345; 
	private int EmployeeID = 1;
	private double hours;
	
	/**
	*
	* Constructor for new employees which create a new text file when the admin adds the employee.
	*
	**/
	
	public Employee(String name) throws IOException{
		setName(name);
		this.filename = name + ".txt";
		File file = new File(filename);
		FileWriter writer = new FileWriter(filename);
		newEmployee(name);
	}
	public Employee(){}
	
	/**
	*
	* Copy constructor for an employee.
	*
	**/
	
 	public Employee(Employee copyEmployee){
		name = copyEmployee.name;
		title = copyEmployee.title;
		salary = copyEmployee.salary;
	} 
	
	/**
	*
	* Method which adds default information to the employee file. 
	*
	**/
	
	public void newEmployee(String name) throws IOException{
		FileWriter writer = new FileWriter(filename);
		PrintWriter printer = new PrintWriter(writer);
		printer.println("Password: ");
		printer.println(title);
		printer.println(EmployeeID);
		printer.println(salary);
		printer.println(hours);
		printer.close();
	}
	
	/**
	*
	* Setter methods for each instance variable.
	*
	**/
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
	public void setHours(double hours){
		this.hours = hours;
	}
	
	/**
	*
	* Getter methods for each instance variable.
	*
	**/
	
	public String getName(){
		return name;
	}
	public String getTitle(){
		return title;
	}
	public double getSalary(){
		return salary;
	}
	public double getHours(){
		return hours;
	}
}