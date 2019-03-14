import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Admin{
	
	/**
	*
	* Instance variables
	*
	**/
	
	private String filename;
	boolean exists = false;
	private String name;
	private File file;
	Scanner keyboard = new Scanner(System.in);
	
	/*
	*
	* Constructor which takes the inputed name and creates a new admin in a form of a text file.
	*
	**/
	
	public Admin(String name) throws IOException{
		
		this.name = name;
		this.filename = name + ".txt";
		File file = new File(filename);
		this.file = file;
		
	}
	
	public Admin(){}
	
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
	
	/*
	*
	* Method which will take an existing employee's name and replace it with another name.
	* https://stackoverflow.com/questions/1158777/rename-a-file-using-java
	*/

	public void renameEmployee(String name, String renameName) throws IOException{
		File oldName = new File(name + ".txt");
		File newName = new File(renameName + ".txt");
		oldName.renameTo(newName);
		System.out.println("Successfully renamed " + name + " to " + renameName);
		
	}
	
	/**
	* This method appends employees into existing text files.
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
	*  Checks whether the file exists and returns either True or False.
	*/
		 
	public boolean checkExists(){
		exists = file.exists();
		return exists;
	}
	
	/**
	*
	* Getter methods that return the instance variables.
	*
	*/
	
	public String getFilename(){
		return filename;
	}
	
	public File getFile(){
		return file;
	}
	public String getName(){
		return name;
	}
	
	/**
	*  if the file does not exist, prompt a registration. This includes
	*  creating a writer object and print object. Adapated from https://www.youtube.com/watch?v=k3K9KHPYZFc
	*/
	
	public void newAdmin(String password) throws IOException{

		FileWriter writer = new FileWriter(filename);
		PrintWriter printer = new PrintWriter(writer);	
		printer.println("Password: " + password);
		printer.println("Admin");
		printer.close();
			
	}

	/**
	 *  if the file does exist, the user is prompted to confirm the password
	 *  associated with their account (specified text file).
	 */

	public void existingAdmin() throws IOException{

		System.out.println("-----------------------------------");
		System.out.println("Welcome, You are already registered");
		System.out.println("Please enter your password: ");
		System.out.println("-----------------------------------");
				
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
			if (line.matches("Password: " + enteredPass)) {
				System.out.println("Welcome " + name);
				correctPass = true;
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
						 if (line.matches("Password: " + newEnteredPass)) {
							System.out.println("Welcome " + name);
							correctPass = true;
									
						}
					}
				}
			}		
		}
	}