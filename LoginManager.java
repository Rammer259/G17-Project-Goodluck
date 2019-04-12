import java.io.*;
import java.util.ArrayList;
/**
 * @author mimel
 *
 */
public class LoginManager{

	private String fileName = "admins.txt";
	private ArrayList<String> admins = new ArrayList<String>();

	public void addAdmin(String user, String pass){

		try{
			String adminInfo = (user + "\t" + pass);
			this.admins.add(adminInfo);
			File file = new File(fileName);
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write( "\n" + adminInfo);
			//br.write( "\n" + user + "\t" + pass + "");
			br.close();
			fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public ArrayList<String> getAdmins(){
		return admins;
	}

	/**
	 * @param user
	 * @param pass
	 * @return
	 */
	boolean checkAdmin(String user, String pass){
		user = user.trim();
		pass = pass.trim();
		// The name of the file to open.

		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader =
					new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader =
					new BufferedReader(fileReader);
			String[] parts;
			while((line = bufferedReader.readLine()) != null) {
				parts = line.split("\t");
				if ( (user.equals( parts[0].trim()) ) && (pass.equals(parts[1].trim())) ){
					System.out.println("LOGGED IN " + user + " SUCCESSFULY! ");
					return true;
				}
			}

			// Always close files.
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" +
							fileName + "'");
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '"
							+ fileName + "'");
		}

		return false;
	}

	public static void main(String[] args) {
	}
}

//https://www.journaldev.com/881/java-append-to-file#java-append-content-to-existing-file-using-bufferedwriter
