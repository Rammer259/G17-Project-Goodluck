import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Admin{
	
	private String filename;
	
	public Admin(String name){
		
		this.filename = name + ".txt";
		File file = new File(filename);
		
	}
	
		System.out.println("------------------------------------------------------------");
		System.out.println("Hello. Please Enter Your First and Last Name.(ex: BobSmith): ");
		System.out.println("------------------------------------------------------------");
		
		name = keyboard.nextLine();
		System.out.println("");
		
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
				System.out.println("");
				password = keyboard.nextLine();
				
				FileWriter writer = new FileWriter(file);
				PrintWriter printer = new PrintWriter(writer);
				
				printer.println("Password: " + password);
				printer.println("Admin");
				printer.close();
				
				System.out.println("----------------------------------------------------------------------------------------------------------------");
				System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'X' to exit program:");
				System.out.println("----------------------------------------------------------------------------------------------------------------");
				
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
					if (line.contains(enteredPass)) {
						System.out.println("Welcome " + name);
						correctPass = true;
						
						System.out.println("----------------------------------------------------------------------------------------------------------------");
						System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'X' to exit program:");
						System.out.println("----------------------------------------------------------------------------------------------------------------");
						
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
							int count = 0;
							System.out.println("Incorrect Password");
							System.out.print("Please Enter your Password: ");
							String newEnteredPass = keyboard.nextLine();
							Scanner newScanner = new Scanner(file);
							while (newScanner.hasNextLine()) {
								String newLine = newScanner.nextLine();
								count++;
								if(count > 5){
									System.out.println("Too many incorrect attempts.");
								}
								// if correct
								if (newLine.contains(newEnteredPass)) {
									System.out.println("Welcome " + name);
									correctPass = true;
									
							System.out.println("----------------------------------------------------------------------------------------------------------------");
							System.out.println("'ADD' to add employee, 'VIEW' to view employees, 'COUNT' to display number of employees hired, 'X' to exit program:");
							System.out.println("----------------------------------------------------------------------------------------------------------------");
									
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