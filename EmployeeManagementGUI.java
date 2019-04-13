import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeManagementGUI {
	public DataIO data;
	public LoginManager loginmanager;

	ArrayList<Employee> employees;
	Scanner scanner;
	String line = "";
	boolean validLogin;
	String fileName = "";

	public void removeEmployeesfromArray(Employee emp) {
		employees.remove(emp);
	}

	public void setEmployeesArray(ArrayList<Employee> newArray) {
		this.employees = newArray;
	}

	public void addEmployeestoArray(Employee emp) {
		employees.add(emp);
	}

	public ArrayList<Employee> getEmployeesArray() {
		return employees;

	}

	public EmployeeManagementGUI() {
		scanner = new Scanner(new InputStreamReader(System.in));
		employees = new ArrayList<Employee>();
		validLogin = false;
		loginmanager = new LoginManager();
	}

	/**
	 * connect to DATAIO object to be able to store and retrieve data from .txt file
	 */
	public void connectToFile() {
		data = new DataIO(fileName, employees);
		data.populateEmployees();
		// System.out.println("IMPORTING EMPLOYEES FROM .TXT FILE! ");
	}

	public boolean manageLogin(String user, String pass) {
		boolean condition = false;
		if (loginmanager.checkAdmin(user, pass)) {
			validLogin = true;
			fileName = user.trim() + ".txt";
			condition = true;

		}
		return condition;
	}

	public void register(String user, String pass) {
		fileName = user.trim() + ".txt";
		loginmanager.addAdmin(user, pass);
	}

	public void addNewEmployee(String first, String last, String dept, String sh, String sal, String con) {

		Employee emp = new Employee(first, last, dept, sh, sal, con);
		employees.add(emp);
	}

	public void endSession() {
		data.saveEmployees();
		scanner.close();
	}

	public void printAllEmployees() {

		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).toString());
		}
	}

	public static void displayOptions() {
		System.out.println("-------------OPTIONS------------");
		System.out.println("type....");
		System.out.println("'COUNT'		-> to display number of employees under your administration.");
		System.out.println("'VIEW'		-> to display ALL employees info under your administration.");
		System.out.println("'ADD'		-> to add an employee under your administration.");
		System.out.println("'SEARCH'		-> to add an employee under your administration.");
		System.out.println("'REMOVE'	-> to Remove an employee from your administration.");
		System.out.println("'AVAIL'		-> to check if an employee is currently working");
		System.out.println("'QUIT'		-> EXIT");
		System.out.println("--------------------------------");
	}

	// MAIN MENU FUNCTION
	/**
	 *
	 */
	public void run() {
		boolean stop = false;

		while (!stop) {
			displayOptions();
			line = scanner.nextLine();

			System.out.println();
			if (line == null) {
				// System.out.println("please enter valid command!");
			}
			if (line.equalsIgnoreCase("COUNT")) {
				if (employees == null || employees.size() == 0) {
					// System.out.println("LIST IS EMPTY");
				} else {

					// System.out.println("There are: " + employees.size() + " employees under your
					// admin. ");
				}
			}
			if (line.equalsIgnoreCase("VIEW")) {
				printAllEmployees();

			}
			if (line.equalsIgnoreCase("ADD")) {
				addNewEmployee("", "", "", "", "", "");

			}
			if (line.equalsIgnoreCase("REMOVE")) {
				Employee found;

				// System.out.println("enter an employees first name and last name - seperated
				// by a space ");
				line = scanner.nextLine();
				String[] parts = line.split(" ");

				if (parts.length == 2) {
					found = searchEmployee(parts[0], parts[1]);
					employees.remove(found);
				}
			}

			if (line.equalsIgnoreCase("SEARCH")) {
				// System.out.println("enter an employees first name and last name - seperated
				// by a space ");
				line = scanner.nextLine();
				String[] parts = line.split(" ");
				Employee em = searchEmployee(parts[0], parts[1]);
				if (em != null) {
					System.out.println("FOUND SUCCESSFULLY! : ");
					System.out.println(em.toString());
					System.out.println();
				}
			}

			if (line.equalsIgnoreCase("AVAIL")) {
				Schedule s = new Schedule();
				// System.out.println("Enter the first and last name of the employee seperated
				// by a space");
				line = scanner.nextLine();
				String[] parts = line.split(" ");

				Employee emp = searchEmployee(parts[0], parts[1]);

				if (emp == null) {
					System.out.println("EMPLOYEE NOT FOUND");
				} else {
					boolean isworking = s.isWorking(emp);

					if (isworking == true) {
						System.out.println("YES! " + parts[0] + " is On the Clock");
					} else {
						System.out.println("NO! " + parts[0] + " is not at work. ");
					}
				}
			}

			if (line.equalsIgnoreCase("QUIT")) {
				stop = true;
			}
			System.out.println();
		}
	}

	public Employee searchEmployee(String f, String l) {
		Employee e;
		if (employees == null) {
			System.out.println("list is empty!");
		}
		for (int i = 0; i < employees.size(); i++) {
			e = employees.get(i);
			if ((f.equalsIgnoreCase(e.getFirstName())) && l.equalsIgnoreCase(e.getLastName())) {
				return e;
			}
		}

		System.out.println("EMPLOYEE NOT FOUND!");
		return null;
	}

	/**
	 * This method removes any line that has the first and last name present Created
	 * because of an error when we linked GUI to other remove method adapted from
	 * https://www.quora.com/How-can-I-delete-a-line-from-a-file-using-Java
	 * 
	 * @param String
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void removal_GUI(String firstName, String lastName) throws IOException, FileNotFoundException {
		File inputFile = new File("employees.txt");
		File tempFile = new File("Updated Employees.txt");
		// used to rename new file
		File finalFile = new File("employees.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String first = firstName;
		String last = lastName;
		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			String trimmed = currentLine.trim();
			if (trimmed.contains(first) && trimmed.contains(last))
				continue;
			writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close();
		reader.close();
		// delete old file
		inputFile.delete();
		// rename to original name
		tempFile.renameTo(finalFile);
	}

	/**
	 * This method prints the text content per line on the ListView of the GUI.
	 * 
	 * @throws IOException
	 * @return ObservableList
	 *
	 */
	public ObservableList view_the_manifest_GUI() throws IOException {
		ArrayList<String> employees = new ArrayList<String>();
		BufferedReader buff = new BufferedReader(new FileReader("employees.txt"));
		String line = buff.readLine();
		while (line != null) {
			employees.add(line);
			line = buff.readLine();
		}
		buff.close();
		ObservableList<String> oEList = FXCollections.observableArrayList(employees);
		return oEList;
	}

	public static void main(String[] args) {

		EmployeeManagement manager = new EmployeeManagement();

		manager.manageLogin();

		manager.connectToFile();

		manager.run();

		manager.endSession();

		System.out.println("hooray!");
	}
}
