import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class utilizes methods from the EmployeeManagement superclass 
 * and allows the user to loop through the menu.
 * 
 * @author Akshat Passi
 * @author Sofian Mustafa
 */
public class MenuTools extends EmployeeManagement {
	private static String choice;
	private static String filename;
	static Scanner keyboard = new Scanner(System.in);
	private static File file;

	/**
	 * The default Constructor for this subclass.
	 * 
	 * @param choice
	 * @param filename
	 * @param keyboard
	 * @param file
	 */
	public MenuTools(String choice, String filename, Scanner keyboard, File file) {
		this.choice = choice;
		this.filename = filename;
		this.keyboard = keyboard;
		this.file = file;
	}

	/**
	 * A loop that generates the menu choices for the user input.
	 * 
	 * @throws IOException
	 */
	public void loop() throws IOException {
		while (!choice.equalsIgnoreCase("X")) {
			
			/**
			 *  if the user chooses to add employees, the user can continue
			 *  to add until they enter '/quit'.
			 */
			if (choice.equalsIgnoreCase("ADD")) {
				System.out.print("Add an employee (/back to return to menu): ");
				String employee = keyboard.nextLine();

				while (!employee.equalsIgnoreCase("/back")) {
					addEmployee(employee, file);
					System.out.print("Add an employee (/back to return to menu): ");
					employee = keyboard.nextLine();
				}
			 }

			/**
			 *  if the user chooses to view employees, display all employees line
			 *  by line by calling the ReadFile class.
			 */
			if (choice.equalsIgnoreCase("VIEW")) {
				ReadFile r = new ReadFile(filename);
				r.openFile();
				r.readFile();
				r.closeFile();
			}
			
			/**
			 *  Calls the numEmployees method, takes the current file as the argument, 
			 *  and prints the count of the employees.
			 */
			if (choice.equalsIgnoreCase("COUNT")) {
				System.out.println("Number of employees hired: " + numEmployees(filename));
			}
			System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'X' to exit program:");
			choice = keyboard.nextLine();
		}
	}
}
