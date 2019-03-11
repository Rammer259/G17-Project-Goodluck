import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

 /**
  * This is the Main class for the program.
  * 
  */

public class EmployeeManagement {

	private static String password;

    /**
	 * This method displays the number of employees listed in the text file
	 * adapted from https://stackoverflow.com/questions/1277880/how-can-i-get-the-count-of-line-in-a-file-in-an-efficient-way 
	 *
	 * @param filename
	 * @return employeeCount
	 * @throws IOException
	 */
	public static long numEmployees(String filename) throws IOException {
		Path path = Paths.get(filename);
		long lineCount = Files.lines(path).count();
		long employeeCount = lineCount - 2;
		return employeeCount;
	}

	public void setName(String name, String renameName){
		File oldName = new File(name + ".txt");
		File newName = new File(renameName + ".txt");
		oldName.renameTo(newName);
		System.out.println("Successfully renamed " + name + " to " + renameName);
	}

   /**
    	* This method appends employees into existing text files
	* 
	* @param employee
	* @param file
	* @throws IOException
	*/
	public static void addEmployee(String employee, File file) throws IOException {
		FileWriter writer = new FileWriter(file, true);
		Employee E = new Employee(employee);
		// Create Print object
		PrintWriter printer = new PrintWriter(writer);
		printer.println(employee);
		printer.close();
	}

    /**
     	* Main argument that creates an employee file.
     	* 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String name;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Hello. Please Enter Your First and Last Name(ex: BobSmith): ");
		name = keyboard.nextLine();
		String filename = name + ".txt";
		File file = new File(filename);

		/**
		 *  Checks whether the file exists and returns either True or False.
		 */
		boolean exists = file.exists();

		/**
		 *  if the file does not exist, prompt a registration. This includes
		 *  creating a writer object and print object. Adapated from https://www.youtube.com/watch?v=k3K9KHPYZFc
		 */
		if (!exists) {
			System.out.print("Welcome New User, Please Choose a Password: ");
			password = keyboard.nextLine();
			
			FileWriter writer = new FileWriter(file);
			PrintWriter printer = new PrintWriter(writer);
			
			printer.println("Password: " + password);
			printer.println("Admin");
			printer.close();
			
			System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'X' to exit program:");
			String choice = keyboard.nextLine();

			/**
			 *  An object of the ChoiceTools class is created and the loop method
			 *  is called to allow the user to access the choices.
			 */
			MenuTools choiceObj = new MenuTools(choice, filename, keyboard, file);
			choiceObj.loop();
		}

		/**
		 *  if the file does exist, the user is prompted to confirm the password
		 *  associated with their account (specified text file).
		 */
		else {
			System.out.println("Welcome, You are already registered");
			System.out.print("Please Enter your Password: ");
			
			String enteredPass = keyboard.nextLine();
			Scanner scanner = new Scanner(file);

			/**
			 *  Scans for the user entered password inside the file. Adapted from 
			 *  https://stackoverflow.com/questions/5600422/method-to-find-string-inside-of-the-text-file-then-getting-the-following-lines
			 */
			boolean correctPass = false;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				/**
				 *  If the password input is correct, an object of the ChoiceTools 
				 *  class is created and the loop method is called to allow the user
				 *  to access the choices.
				 */ 
				if (line.contains(enteredPass)) {
					System.out.println("Welcome " + name);
					correctPass = true;

					System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'X' to exit program:");
					String choice = keyboard.nextLine();

					MenuTools choiceObj = new MenuTools(choice, filename, keyboard, file);
					choiceObj.loop();
				}

				/**
				 *  If wrong, the user is inserted to a loop where they are informed
				 *  the password is incorrect and prompted to enter the password again.
				 */
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