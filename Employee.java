import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Employee extends EmployeeManagement{

	private String name;
 	private String title = "employee";
	private double salary = 12345; 
	
	public Employee(String name) throws IOException{
		setName(name);
		newEmployee(name);
	}
	
 	public Employee(Employee copyEmployee){
		name = copyEmployee.name;
		title = copyEmployee.title;
		salary = copyEmployee.salary;
	} 
	
	public void newEmployee(String name) throws IOException{
		String filename = name + ".txt";
		String defaultPassword = "Password:";
		File file = new File(filename);
		FileWriter writer = new FileWriter(filename);
		PrintWriter printer = new PrintWriter(writer);
		printer.println(defaultPassword);
		printer.println(title);
		printer.println(salary);
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
	
}