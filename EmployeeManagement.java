import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
 * Main class for the program
 * 
 * @author Akshat Passi
 * @author Sofian Mustafa
 * 
 */
public class EmployeeManagement {

	private static String password;

	/*
	 * 
	 * This method displays the number of employees listed in the text file
	 * 
	 * @param filename
	 * 
	 * @return employeeCount
	 */
	public static long numEmployees(String filename) throws IOException {
		Path path = Paths.get(filename);
		long lineCount = Files.lines(path).count();
		long employeeCount = lineCount - 1;
		return employeeCount;
	}

	/*
	 * This method appends employees into existing text files
	 * 
	 * @param employee
	 * 
	 * @param file
	 */
	public static void addEmployee(String employee, File file) throws IOException {
		FileWriter writer = new FileWriter(file, true);
		// Create Print object
		PrintWriter printer = new PrintWriter(writer);
		printer.println(employee);
		printer.close();
	}

	public static void main(String[] args) throws IOException {
		String name;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Hello Please Enter Your First and Last Name(ex: BobSmith): ");
		name = keyboard.nextLine();
		String filename = name + ".txt";

		// Create File
		File file = new File(filename);

		// Check whether the file exists(returns True or False)
		boolean exists = file.exists();

		// if the file does not exist, prompt a registration
		if (!exists) {
			System.out.print("Welcome New User, Please Choose a Password: ");
			password = keyboard.nextLine();
			// Create Writer Object
			FileWriter writer = new FileWriter(file);
			// Create Print object
			PrintWriter printer = new PrintWriter(writer);

			printer.println("Password" + ": " + password);
			printer.close();
			
			System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'X' to exit program:");
			String choice = keyboard.nextLine();

			// An object of the ChoiceTools class is created and the loop method is called
			// to allow the user to access the choices.
			MenuTools choiceObj = new MenuTools(choice, filename, keyboard, file);
			choiceObj.loop();
		}

		// if the file does exist prompt the user to confirm the password associated
		// with the account (text file)
		else {
			System.out.println("Welcome, You are already registered");
			System.out.print("Please Enter your Password: ");
			String enteredPass = keyboard.nextLine();
			Scanner scanner = new Scanner(file);

			// Scan for entered password inside the file
			boolean correctPass = false;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				// if correct
				if (line.contains(enteredPass)) {
					System.out.println("Welcome " + name);
					correctPass = true;

					System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'X' to exit program:");
					String choice = keyboard.nextLine();

					// An object of the ChoiceTools class is created and the loop method is called
					// to allow the user to access the choices.
					MenuTools choiceObj = new MenuTools(choice, filename, keyboard, file);
					choiceObj.loop();
				}

				// if wrong(Loop added, duplicated code needs to be removed)
				else {
					while (correctPass == false) {
						System.out.println("Incorrect Password");
						System.out.print("Please Enter your Password: ");
						String newEnteredPass = keyboard.nextLine();
						Scanner newScanner = new Scanner(file);
						while (newScanner.hasNextLine()) {
							String newLine = newScanner.nextLine();
							// if correct
							if (newLine.contains(newEnteredPass)) {
								System.out.println("Welcome " + name);
								correctPass = true;
								System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'X' to exit program:");
								String choice = keyboard.nextLine();
								MenuTools choiceObj = new MenuTools(choice, filename, keyboard, file);
								choiceObj.loop();

							}

						}

					}
				}

			}
		}
	}
}