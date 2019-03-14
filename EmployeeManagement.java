import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

 /**
  * This is the Main class for the program.
  * 
  */

public class EmployeeManagement {

	private static String password;
	
	public String getTasks(){
		String tasks = "insert tasks here.";
		return tasks;
	}
	
	public String getPassword(){
		return password;
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
		
		System.out.println("---------------------------------");
		System.out.println("Login as an admin or an employee?");
		System.out.println("---------------------------------");
		
		String rank = keyboard.nextLine();
		
		if(rank.equalsIgnoreCase("employee")){
			
			
			System.out.println("------------------------------------------------------------");
			System.out.println("Hello. Please Enter Your First and Last Name.(ex: BobSmith):");
			System.out.println("------------------------------------------------------------");
		
			name = keyboard.nextLine();
			System.out.println("");
		
			String filename = name + ".txt";
			File file = new File(filename);
			
			/**
			 *  Checks whether the file exists and returns either True or False.
			 */
			
			boolean exists = file.exists();
			
			Scanner scanner = new Scanner(file);
			
			/**
			 *  if the file does not exist, prompts an error message. 
			 */
			if (exists == false){
				System.out.print("Sorry that name does not exist. Please contact an administrator for more help.");
			}
		
			/**
			 *  If the file does exist, the user is prompted to confirm the password
			 *  associated with their account (specified text file). If the employee
			 *  has not logged in before, it will prompt the employee to create a new
			 *  password. 
			 *  https://stackoverflow.com/questions/3935791/find-and-replace-words-lines-in-a-file
			 */ 
			else{
				String line = scanner.nextLine();
				boolean correctPass = false;
					
					if(line.matches("Password: ")){
					
						System.out.println("-----------------------------");
						System.out.println("Please enter a new password: ");
						System.out.println("-----------------------------");
					
						String newPassword = keyboard.nextLine();
						Path path = Paths.get(filename);
						Charset charset = StandardCharsets.UTF_8;

						String content = new String(Files.readAllBytes(path), charset);
						content = content.replaceAll("Password: ", "Password: " + newPassword);
						Files.write(path, content.getBytes(charset));
						
						System.out.println("Welcome " + name);
							
						System.out.println("-----------------------------------------------------------------------------------");
						System.out.println("'VIEW' to check upcoming tasks, 'HOURS' to check weekly hours, 'X' to exit program:");
						System.out.println("-----------------------------------------------------------------------------------");
							
						String choice = keyboard.nextLine();

						EmployeeTools choiceObj = new EmployeeTools(choice, filename, keyboard, file);
						choiceObj.loop();
						
					}
					
					/**
					 *  Scans for the user entered password inside the file. Adapted from 
					 *  https://stackoverflow.com/questions/5600422/method-to-find-string-inside-of-the-text-file-then-getting-the-following-lines
					 */
					
					else if(correctPass == false){
						
						System.out.println("----------------------------");
						System.out.println("Please enter your password: ");
						System.out.println("----------------------------");
					
						String enteredPass = keyboard.nextLine();

							/**
							 *  If the password input is correct, an object of the ChoiceTools 
							 *  class is created and the loop method is called to allow the user
							 *  to access the choices.
							 */ 
							if (line.matches("Password: " + enteredPass)) {
								System.out.println("Welcome " + name);
								correctPass = true;
								
								System.out.println("-----------------------------------------------------------------------------------");
								System.out.println("'VIEW' to check upcoming tasks, 'HOURS' to check weekly hours, 'X' to exit program:");
								System.out.println("-----------------------------------------------------------------------------------");
								
								String choice = keyboard.nextLine();

								EmployeeTools choiceObj = new EmployeeTools(choice, filename, keyboard, file);
								choiceObj.loop();
							}

							/**
							 *  If wrong, the user is inserted to a loop where they are informed
							 *  the password is incorrect and prompted to enter the password again.
							 */
							else if(!line.matches("Password: " + enteredPass)){
								while (correctPass == false){
									System.out.println("Incorrect Password.");
									
									System.out.println("----------------------------");
									System.out.println("Please enter your password: ");
									System.out.println("----------------------------");
									
									enteredPass = keyboard.nextLine();
									Scanner newScanner = new Scanner(file);
										if (line.matches("Password: " + enteredPass)) {
											System.out.println("Welcome " + name);
											correctPass = true;
											
											System.out.println("-----------------------------------------------------------------------------------");
											System.out.println("'VIEW' to check upcoming tasks, 'HOURS' to check weekly hours, 'X' to exit program:");
											System.out.println("-----------------------------------------------------------------------------------");
											
											String choice = keyboard.nextLine();
											EmployeeTools choiceObj = new EmployeeTools(choice, filename, keyboard, file);
											choiceObj.loop();

										}
									}
								}
							}
						 }
					 }
					 
		if(rank.equalsIgnoreCase("admin")){
		
			System.out.println("------------------------------------------------------------");
			System.out.println("Hello. Please Enter Your First and Last Name.(ex: BobSmith): ");
			System.out.println("------------------------------------------------------------");
		
			name = keyboard.nextLine();
			System.out.println("");
			Admin a = new Admin(name);
		
			boolean exists = a.checkExists();
				
			/**
			*  if the file does not exist, prompt a registration. This includes
			 *  creating a writer object and print object. Adapated from https://www.youtube.com/watch?v=k3K9KHPYZFc
			 */
			if (!exists){
				
				System.out.print("Welcome New User, Please Choose a Password: ");
				System.out.println("");
				String password = keyboard.nextLine();
				
				a.newAdmin(password);
				
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'RENAME' to rename an employee, 'X' to exit program:");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
				
				String choice = keyboard.nextLine();

				/**
				 *  An object of the ChoiceTools class is created and the loop method
				 *  is called to allow the user to access the choices.
				 */
				MenuTools choiceObj = new MenuTools(choice, a.getFilename(), keyboard, a.getFile());
				choiceObj.loop();
			}
		
			/**
			 *  if the file does exist, the user is prompted to confirm the password
			 *  associated with their account (specified text file).
			 */
			else{
				a.existingAdmin();
				
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'RENAME' to rename an employee, 'X' to exit program:");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
						
				String choice = keyboard.nextLine();

				MenuTools choiceObj = new MenuTools(choice, a.getFilename(), keyboard, a.getFile());
				choiceObj.loop();
			}
		}
	}
}