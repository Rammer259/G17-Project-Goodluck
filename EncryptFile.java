import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EncryptFile extends EncryptDecrypt{
	private static String file;

	public EncryptFile(String filename) {
		file = filename;
	}

	public static void main(String args[]) {
			try {
				System.out.println(file);
				
				EncryptDecrypt process = new EncryptDecrypt("fdskjfsadufis.aldfjlsfl.");
				String v = process.encrypt(file);
				
				FileWriter writer = new FileWriter("file", false);
				PrintWriter printer = new PrintWriter(writer);
				
				printer.print(v);
				printer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
}
}
