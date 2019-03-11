import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;
import java.util.Scanner;
import java.util.Base64.Decoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
public class EncryptDecrypt extends EmployeeManagement {
	private static String nameOfAl = "AES";
	private byte[] valueOfKey;
	
	public EncryptDecrypt() {
		
	}
	public EncryptDecrypt(String key) {
		valueOfKey = key.getBytes();
	}
	
	public void encrypt (String fileName) throws Exception{
		
		//**************************************
		//https://stackoverflow.com/questions/14169661/read-complete-file-without-using-loop-in-java
		File file = new File(fileName);
		FileInputStream dataIn = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		dataIn.read(data);
		dataIn.close();
		//***************************************
		
		String allData = new String(data);
		System.out.print(allData);
		Key key =  generateKey();
		Cipher c = Cipher.getInstance(nameOfAl);
		c.init(Cipher.ENCRYPT_MODE, key);			
		byte[] encVal = c.doFinal(allData.getBytes());
		String encryptedValue = Base64.getEncoder().encodeToString(encVal);
		
		
		FileWriter writer = new FileWriter("file", false);
		PrintWriter printer = new PrintWriter(writer);
		
		printer.print(encryptedValue);
		printer.close();
	}
	public void decrypt (String encryptedData) throws Exception{
		Key key = generateKey();
		Cipher c = Cipher.getInstance(nameOfAl);
		c.init(Cipher.DECRYPT_MODE, key);
		byte [] decodedValue = (Base64.getDecoder().decode(encryptedData.getBytes()));
		byte [] decValue = c.doFinal(decodedValue);
		String decryptedValue = new String(decValue);
		
		FileWriter writer = new FileWriter("file", false);
		PrintWriter printer = new PrintWriter(writer);
		
		printer.print(decryptedValue);
		printer.close();
		
		
	}
	
	

	
	private Key generateKey() throws Exception{
		Key key = new SecretKeySpec(valueOfKey,nameOfAl);
		return key;
	}
}
