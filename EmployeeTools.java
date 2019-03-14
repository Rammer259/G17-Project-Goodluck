import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class EmployeeTools extends Employee{
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
	public EmployeeTools(String choice, String filename, Scanner keyboard, File file) {
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

			if (choice.equalsIgnoreCase("VIEW")) {
				
				System.out.println("----------------");
				System.out.println("Upcoming tasks: " + getTasks());
				System.out.println("----------------");
				
			}

			if(choice.equalsIgnoreCase("HOURS")){
				
				System.out.println("-------");
				System.out.println("Hours: " + getHours());
				System.out.println("-------");
			}
			
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("'VIEW' to check upcoming tasks, 'HOURS' to check weekly hours, 'X' to exit program:");
			System.out.println("-----------------------------------------------------------------------------------");
		choice = keyboard.nextLine();
		}
	}
}