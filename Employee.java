import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;

/**
 * This class defines an object called Employee that
 * holds the information of employees in the program
 *
 * @author mimel
 */
public class Employee{

	private String firstName;
	private String lastName;
	private String department;
	private String shift;
	private String salary;
	private String contact;

	/**
	 * default constructor assigns the variables under
	 * the employee class.
	 *
	 * @param first
	 * @param last
	 * @param dept
	 * @param sh
	 * @param sal
	 * @param cont
	 */
	public Employee(String first, String last, String dept, String sh, String sal,  String cont ){
		firstName = first;
		lastName = last;
		shift = sh;
		salary = sal;
		department = dept;
		contact = cont;
	}

	/*
	 * A toString function that turns the parameters
	 * to string. \t is used to space out the information
	 * but keep all variables in one line.
	 */
	public String toString(){
		return firstName + "\t " + lastName + "\t " + department + "\t " + shift + "\t " +  salary + "\t " + contact ;
	}

	/**
	 * A from string function that takes a toString line
	 * and splits it into parts at the tab spaces. Each
	 * variable is assigned to a part of the toString line.
	 *
	 * @param input
	 * @return e
	 */
	public static Employee fromString(String input ){
		String[] parts= input.split("\t");
		String first = parts[0];
		String last = parts[1];
		String dept = parts[2];
		String sh = parts[3];
		String sal = parts[4];
		String cont = parts[5];

		Employee e = new Employee(first,last,dept,sh,sal,cont);
		return e;
	}

	public String getFirstName(){
		return firstName.trim();
	}

	public String getLastName(){
		return lastName.trim();
	}
	public String getShift(){
		return shift.trim();
	}

	public static void main(String[] args) {

	}

}
//References:
//https://docs.oracle.com/javase/7/docs/api/java/io/InputStreamReader.html
//https://www.journaldev.com/791/java-string-split
// https://javarevisited.blogspot.com/2012/12/how-to-read-input-from-command-line-in-java.html#ixzz5i6pxVwQT
