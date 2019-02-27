import java.io.*;
import java.util.*;

/*
 * This class opens, reads, and prints each line to the text file
 * 
 * @author Sofian Mustafa
 * 
 */

public class ReadFile {
	private Scanner x;
	private String filename;

	public ReadFile(String filename) {
		this.filename = filename;
	}

	public void openFile() {
		try {
			// our file is assigned to the variable x
			x = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println("Could not find file");
		}
	}

	public void readFile() {
		// while there is another line in the text file, read that line
		while (x.hasNext()) {
			// if there are spaces between words on the same line in the file,
			// the first word is assigned to String a, the second to String b,
			// and so on.
			String a = x.next();

			System.out.printf("%s\n", a);

		}
	}

	public void closeFile() {
		x.close();
	}

}
