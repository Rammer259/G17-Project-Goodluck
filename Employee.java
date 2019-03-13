import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Employee extends EmployeeManagement{

	private String name;
	private String filename;
 	private String title = "employee";
	private double salary = 12345; 
	private int EmployeeID = 1;
	private double hours;
	
	public Employee(String name) throws IOException{
		setName(name);
		this.filename = name + ".txt";
		File file = new File(filename);
		FileWriter writer = new FileWriter(filename);
		newEmployee(name);
	}
	public Employee(){}
	
 	public Employee(Employee copyEmployee){
		name = copyEmployee.name;
		title = copyEmployee.title;
		salary = copyEmployee.salary;
	} 
	
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
	
	public void setName(String name, String renameName){
		File oldName = new File(this.name + ".txt");
		File newName = new File(name + ".txt");
		oldName.renameTo(newName);
		setName(name);
	}
	public void setName(String name){
		this.name = name;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
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