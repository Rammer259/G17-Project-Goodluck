import java.io.*;
import java.util.*;

/**
 * This class opens, reads, and prints every line to the console
 * Adapted from https://www.youtube.com/watch?v=3RNYUKxAgmw
 *
 */
public class ReadFile {
	private Scanner newScanner;
	private String filename;

	/**
	 * Constructor that sets the file name.
	 * 
	 * @param filename
	 */
	public ReadFile(String filename) {
		this.filename = filename;
	}

	/**
	 *  Void function that assigns specified file to the variable x.
	 */
	public void openFile() {
		try {
			newScanner = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println("Could not find file");
		}
	}
	/** Void function that reads the contents of the specified file.
	 * 
	 */
	public void readFile() {
		/*
		 * while there is another line in the text file, the 
		 * function reads that line. If there are spaces between words
		 * on the same line in the file, the first word is assigned to
		 * String a, the second to String b, and so on. Adapted from
		 * https://www.youtube.com/watch?v=3RNYUKxAgmw
		 */
		while (newScanner.hasNext()) {
			String a = newScanner.next();
			System.out.printf("%s\n", a);
		}
	}
	
	/**
	 * Void function that closes the file.
	 */
	public void closeFile() {
		newScanner.close();
	}

}
