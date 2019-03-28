import java.io.*;
import java.util.ArrayList;

/**
 * This class handles the administrator's personal .txt
 * file, which contains the employee information.
 *
 * @author mimel
 *
 */
public class DataIO{

    private ArrayList employees;
    public String fileName;
    public FileReader fileReader;
    public BufferedReader bufferedReader;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    /**
     * A constructor that assigns the variables fileName
     * and employees
     *
     * @param file
     * @param list
     */
    public DataIO(String file, ArrayList list){
    	fileName = file;
    	employees = list;
    }

    /**
     * A from string function that takes a String line
	 * and splits it into parts at the tab spaces. Each
	 * variable is assigned to a part of the employee variables.
	 *
     * @param input
     * @return e
     */
    public static Employee fromString(String input ){
    	String[] parts= input.split("\t");
    	String first = parts[0];
    	String last = parts[1];
    	String dept = parts[2];
    	String sh = parts[3];
    	String sal = parts[4];
    	String cont = parts[5];

    	Employee e = new Employee(first,last,dept,sh,sal,cont);
    	return e;

    }

    /**
     * Function used to import the employee's information from
     * the specified admin's .txt file. FileReader finds the
     * admin's .txt and bufferedReader reads the text inside it.
     * the for loop is used to read each employee line by line.
     */
    public void populateEmployees(){
                System.out.println("WERE READING FROM: " + fileName);

                String line = null;
                 try {

                    FileReader fileReader = new FileReader(fileName);

                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    while((line = bufferedReader.readLine()) != null) {
                    	fromString(line);

                        if (employees == null){
                            System.out.println("EMPLOYEEES ARE NULL D:");
                        }

                        employees.add(fromString(line));
                    }

                    Employee e;
                    for(int i = 0 ; i < employees.size() ; i++ ){
                    e = (Employee) employees.get(i);
                    System.out.println(e.toString());
                }

                    bufferedReader.close();
                }
                catch(FileNotFoundException ex) {
                    System.out.println(  "Unable to open file '" + fileName + "'");
                }

                catch(IOException ex) {
                    System.out.println( "Error reading file '"  + fileName + "'");
                    ex.printStackTrace();
             }
                catch(NullPointerException npe){
                    System.out.println("oops.");
                }
    }

        /**
         * A void function that saves the employee's information to
         * the specified admin's .txt file. filewriter and
         * bufferedWriter are used to write to the text file
         *  while a for loop is used to write each employee
         *  line by line.
         */
        public void saveEmployees(){

            try {
                FileWriter fileWriter = new FileWriter(fileName);

                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                //write out each employee line by line
                for(int i =0; i < employees.size() ; i++ ){
                bufferedWriter.write(employees.get(i).toString());
                bufferedWriter.newLine();
                }

                // Always close files.
                bufferedWriter.close();
            }

            catch(IOException ex) {
                System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
            }

        }

    	public static void main(String[] args) {
    		ArrayList<Employee> myList = new ArrayList<Employee>();
    	}
}

//https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
