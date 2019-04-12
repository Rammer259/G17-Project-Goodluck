import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;

/**
 * This class defines an object called Employee that
 * holds the information of employees in the program
 *
 */
public class Employee{

	private String firstName;
	private String lastName;
	private String department;
	private String shift;
	private String salary;
	private String contact;
	private static final int FIRST = 0;
	private static final int LAST = 1;
	private static final int DEPARTMENT = 2;
	private static final int SHIFT = 3;
	private static final int SALARY = 4;
	private static final int CONTACT = 5;

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

	/**
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
		String first = parts[FIRST];
		String last = parts[LAST];
		String dept = parts[DEPARTMENT];
		String sh = parts[SHIFT];
		String sal = parts[SALARY];
		String cont = parts[CONTACT];

		Employee e = new Employee(first,last,dept,sh,sal,cont);
		return e;
	}
	
	/**
	 * get methods
	 * 
	 */

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
