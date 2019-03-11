import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DecryptFile extends EncryptDecrypt{
	
	public DecryptFile(String key) {
		super(key);
	}

	public static void main(String args[]) {
		try {
			EncryptDecrypt process = new EncryptDecrypt("fdskjfsadufis.aldfjlsfl.");
			FileWriter writer = new FileWriter("JohnCena.txt", false);
			PrintWriter printer = new PrintWriter(writer);
			String v = process.encrypt("JohnCena.txt");
			
			String decData = process.decrypt(v);
			printer.println(decData);
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
