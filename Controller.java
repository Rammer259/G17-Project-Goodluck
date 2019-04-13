
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.*;
import java.io.*;

/**
 * this class controllers and handles all the displayed gui's and acts as the controlling class for every fxml file.
 */
public class Controller extends EmployeeManagementGUI {
	/**
	 * these are all the objects from the fxml file that we may need to interact
	 * with or update, as of current many are unused.
	 */

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="FirstName_Field" via Screen_Add_Employee
	private TextField FirstName_Field; //

	@FXML // fx:id="LastName_Field" via Screen_Add_Employee
	private TextField LastName_Field; //

	@FXML // fx:id="Department_Field" via Screen_Add_Employee
	private TextField Department_Field;

	@FXML // fx:id="Shift_Field" via Screen_Add_Employee
	private TextField Shift_Field;

	@FXML // fx:id="Salary_Field" via Screen_Add_Employee
	private TextField Salary_Field;

	@FXML // fx:id="Phone_Field" via Screen_Add_Employee
	private TextField Phone_Field;

	@FXML // fx:id="Admin_Tab" via Screen2
	private Tab Admin_Tab;

	@FXML // fx:id="Primary_Pane" via Login
	private AnchorPane Primary_Pane;

	@FXML // fx:id="Secondary_Pane" via Screen2
	private AnchorPane Secondary_Pane;

	@FXML // fx:id="AddEmployee_Pane" via Screen_Add_Employee
	private AnchorPane AddEmployee_Pane;

	@FXML // fx:id="Confirm_Pane" via Screen_Confirm_Add
	private AnchorPane Confirm_Pane;

	@FXML // fx:id="Confirm_Pane" via Screen_Confirm_Add
	private AnchorPane Confirm_Two_Pane;

	@FXML
	private AnchorPane RemoveEmployee_Pane;

	@FXML // fx:id="AdminList_Pane" via Screen2
	private ListView<String> AdminList_Pane; //

	@FXML // fx:id="Password_Field" via Login
	private PasswordField Password_Field; //

	@FXML // fx:id="Username_Field" via Login
	private TextField Username_Field; //

	@FXML // fx:id="Quit_Button" Via Multiple
	private Button Quit_Button; //

	@FXML // fx:id="Log_In_Button" via Login
	private Button Log_In_Button; //

	@FXML // fx:id="Label_U" Via Login
	private Label Label_U; //

	@FXML // fx:id="Label_P" Via Login
	private Label Label_P; //

	@FXML // fx:id="Lable_PLI" Via Login
	private Label Lable_PLI; //

	@FXML // fx:id="Register_Button" Via Login
	private Button Register_Button; //

	@FXML // fx:id="Set_Shift_Button" via Screen2
	private Button Set_Shift_Button; //

	@FXML // fx:id="AddEmployee_Button" via Screen_Add_Employee
	private Button AddEmployee_Button; //

	@FXML // fx:id="Cancel_Add_Button" via Screen_Add_Employee
	private Button Cancel_Add_Button; //

	@FXML // fx:id="Confirm_Add_Button" via Screen_Add_Employee
	private Button Confirm_Add_Button; //

	@FXML // via Screen2
	private Button View_Employee_Manifest_Button;

	@FXML // fx:id="RemoveEmployee_Button" via Screen2
	private Button RemoveEmployee_Button;

	@FXML // via Screen_Add_Employee
	private Button Confirm_Remove_Button;

	@FXML // via Screen_Confrim_Remove
	private TextField RemoveFirstName_Field;

	@FXML // via Screen_Confirm_Remove
	private TextField RemoveLastName_Field;

	@FXML // via Screen_Confirm_Remove
	private TextField ConfirmRemoveFirstName_Field;

	@FXML // via Screen_Confirm_Remove
	private TextField ConfirmRemoveLastName_Field;

	/**
	 * calls the checkAdmin method from the LoginManager class to verify user
	 * credentials.
	 *
	 * @param event
	 * @throws IOException, IndexOutOfBoundsException
	 */
	// private EmployeeManagementGUI emgObj = new EmployeeManagementGUI();

	@FXML // from Login.fxml
	public void program_login(ActionEvent event) throws IOException, IndexOutOfBoundsException {

		if (Username_Field.getText().isEmpty() == true || Password_Field.getText().isEmpty() == true) {
			Lable_PLI.setText("Missing Credentials");
		} else {

			boolean condition = super.manageLogin(Username_Field.getText(), Password_Field.getText());
			if (condition == true) {
				super.connectToFile();
				AnchorPane pane = FXMLLoader.load(getClass().getResource("/Screen2.fxml"));
				Primary_Pane.getChildren().setAll(pane);
			} else {
				Lable_PLI.setText("Incorrect Credentials");
			}

		}
	}

	/**
	 * calls the register method from the EmployeeManagementGUI class to verify user
	 *
	 *
	 * @param event
	 *
	 */

	@FXML // from Login.fxml
	void program_register(ActionEvent event) {
		super.register(Username_Field.getText(), Password_Field.getText());
		Lable_PLI.setText("Registration Successful");

	}

	/**
	 * Launches the administrator gui
	 *
	 * @param event
	 */
	// Launches the Add Employee window, with textfield for all information
	@FXML // from Screen2.fxml
	void program_add_employee(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Screen_Add_Employee.fxml"));
		Secondary_Pane.getChildren().setAll(pane);
		// Confirmation Pane

	}

	/**
	 * Adds a new employee to the array of the super class and saves the array to
	 * the file. Returns to screen2 afterwards.
	 *
	 * @param ActionEvent
	 * @throws IOException
	 */
	@FXML // from AddEmployee_Pane.fxml
	void program_confirm_add(ActionEvent event) throws IOException, InterruptedException { // this launches from
		// Screen_Add_Employee
		super.connectToFile();
		super.addNewEmployee(FirstName_Field.getText().toLowerCase(), LastName_Field.getText().toLowerCase(), Department_Field.getText(),
				Shift_Field.getText(), Salary_Field.getText(), Phone_Field.getText());
		System.out.println(super.getEmployeesArray());
		// privacy leak
		super.data.fileName = "employees.txt";
		super.endSession();

		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Screen_Confirm_Add.fxml"));
		AddEmployee_Pane.getChildren().setAll(pane);

		// Confirmation Pane

	}

	/**
	 * Returns to the admin page from Add Employee, will eventually handle returning
	 * from Remove Employee page as well
	 *
	 * @param ActionEvent
	 * @throws IOException
	 */
	// cancel button
	@FXML // from AddEmployee_Pane.fxml
	void program_return_to_Screen2(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Screen2.fxml"));
		AddEmployee_Pane.getChildren().setAll(pane);
	}

	@FXML
	void program_return_to_Screen2_via_Remove(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Screen2.fxml"));
		RemoveEmployee_Pane.getChildren().setAll(pane);

	}

	/**
	 * Unused currently, will handle the shift window functionality
	 *
	 * @param ActionEvent
	 * @throws IOException
	 */

	@FXML // From
	void program_open_shift_window(ActionEvent event) {

	}

	/**
	 * scripted action only, shows example manifest
	 *
	 * @param ActionEvent
	 * @throws IOException
	 */

	@FXML // from Screen2.fxml
	void program_view_manifest(ActionEvent event) throws IOException {
		EmployeeManagementGUI empObj = new EmployeeManagementGUI();
		// ObservableList<String> stringList = FXCollections.observableArrayList("Count:
		// 3", "Mark Jones IT ", "John Smith Janitor", "Tom");
		//
		// EmployeeManagement empMang = new EmployeeManagement();
		// ArrayList<Employee> eList = empMang.getEmployeesArray();
		// if(eList.size() == 0){System.out.println("empty");}
		// ArrayList<String> stringEList = new ArrayList<String>();
		// for(Employee employees : eList){
		// String empString = employees.toString();
		// stringEList.add(empString);
		// }

		AdminList_Pane.setItems(empObj.view_the_manifest_GUI());

	}

	/**
	 * swaps to remove class
	 *
	 * @param ActionEvent
	 * @throws IOException
	 */

	@FXML
	void program_remove_employee(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Screen_Remove_Employee.fxml"));
		Secondary_Pane.getChildren().setAll(pane);

	}

	/**
	 * handles the user clicking the "quit" button.
	 *
	 * @param event
	 */

	@FXML
	void program_quit(ActionEvent event) {
		Platform.exit();
	}

	/**
	 * interacts with a new remove method, called from EmployeeManagementGUI
	 *
	 * @param event
	 */

	@FXML
	void program_confirm_remove(ActionEvent event) throws IOException, FileNotFoundException {
		EmployeeManagementGUI empObj = new EmployeeManagementGUI();
		empObj.removal_GUI(RemoveFirstName_Field.getText().toLowerCase(), RemoveLastName_Field.getText().toLowerCase());

		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Screen_Confirm_Remove.fxml"));
		RemoveEmployee_Pane.getChildren().setAll(pane);

	}
	/**
	 * handles a smooth return to screen2
	 *
	 * @param even
	 */

	@FXML
	void program_return_to_Screen2_via_pop_up(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Screen2.fxml"));
		Confirm_Pane.getChildren().setAll(pane);

	}
	/**
	 * handles a smooth return to screen2
	 *
	 * @param even
	 */

	@FXML
	void program_return_to_Screen2_via_pop_up_remove(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/Screen2.fxml"));
		Confirm_Two_Pane.getChildren().setAll(pane);

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert AddEmployee_Pane != null : "fx:id=\"AddEmployee_Pane\" was not injected: check your FXML file 'Screen_Add_Employee.fxml'.";
		assert Primary_Pane != null : "fx:id=\"Primary_Pane\" was not injected: check your FXML file 'Login.fxml'.";
		assert Password_Field != null : "fx:id=\"Password_Field\" was not injected: check your FXML file 'Login.fxml'.";
		assert Username_Field != null : "fx:id=\"Username_Field\" was not injected: check your FXML file 'Login.fxml'.";
		assert Quit_Button != null : "fx:id=\"Quit_Button\" was not injected: check your FXML file 'Login.fxml'.";
		assert Log_In_Button != null : "fx:id=\"Log_In_Button\" was not injected: check your FXML file 'Login.fxml'.";
		assert Label_U != null : "fx:id=\"Label_U\" was not injected: check your FXML file 'Login.fxml'.";
		assert Label_P != null : "fx:id=\"Label_P\" was not injected: check your FXML file 'Login.fxml'.";
		assert Lable_PLI != null : "fx:id=\"Lable_PLI\" was not injected: check your FXML file 'Login.fxml'.";
		assert Admin_Tab != null : "fx:id=\"Admin_Tab\" was not injected: check your FXML file 'Screen2.fxml'.";
		assert Set_Shift_Button != null : "fx:id=\"Set_Shift_Button\" was not injected: check your FXML file 'Screen2.fxml'.";
		assert AddEmployee_Button != null : "fx:id=\"AddEmployee_Button\" was not injected: check your FXML file 'Screen2.fxml'.";
		assert Register_Button != null : "fx:id=\"Register_Button\" was not injected: check your FXML file 'Screen2.fxml'.";
		assert FirstName_Field != null : "fx:id=\"FirstName_Field\" was not injected: check your FXML file 'Screen_Add_Employee.fxml'.";
		assert LastName_Field != null : "fx:id=\"LastName_Field\" was not injected: check your FXML file 'Screen_Add_Employee.fxml'.";
		assert Department_Field != null : "fx:id=\"Department_Field\" was not injected: check your FXML file 'Screen_Add_Employee.fxml'.";
		assert Shift_Field != null : "fx:id=\"Shift_Field\" was not injected: check your FXML file 'Screen_Add_Employee.fxml'.";
		assert Salary_Field != null : "fx:id=\"Salary_Field\" was not injected: check your FXML file 'Screen_Add_Employee.fxml'.";
		assert Phone_Field != null : "fx:id=\"Phone_Field\" was not injected: check your FXML file 'Screen_Add_Employee.fxml'.";
		assert Cancel_Add_Button != null : "fx:id=\"Cancel_Add_Button\" was not injected: check your FXML file 'Screen_Add_Employee.fxml'.";
		assert Confirm_Add_Button != null : "fx:id=\"Confirm_Add_Button\" was not injected: check your FXML file 'Screen_Add_Employee.fxml'.";
		assert Secondary_Pane != null : "fx:id=\"Secondary_Pane\" was not injected: check your FXML file 'Screen2.fxml'.";
		assert Confirm_Pane != null : "fx:id=\"Confirm_Pane\" was not injected: check your FXML file 'Screen_Confirm_Add.fxml'.";
		assert View_Employee_Manifest_Button != null : "fx:id=\"View_Employee_Manifest_Button\" was not injected: check your FXML file 'Screen2.fxml'.";
		assert RemoveEmployee_Button != null : "fx:id=\"RemoveEmployee_Button\" was not injected: check your FXML file 'Screen2.fxml'.";
		assert Confirm_Remove_Button != null : "fx:id=\"Confirm_Remove_Button\" was not injected: check your FXML file 'Screen_Confirm_Remove.fxml'.";
		assert RemoveFirstName_Field != null : "fx:id=\"RemoveFirstName_Field\" was not injected: check your FXML file 'Screen_Confirm_Remove.fxml'.";
		assert RemoveLastName_Field != null : "fx:id=\"RemoveLastName_Field\" was not injected: check your FXML file 'Screen_Confirm_Remove.fxml'.";
		assert ConfirmRemoveFirstName_Field != null : "fx:id=\"ConfirmRemoveFirstName_Field\" was not injected: check your FXML file 'Screen_Confirm_Remove.fxml'.";
		assert ConfirmRemoveLastName_Field != null : "fx:id=\"ConfirmRemoveLastName_Field\" was not injected: check your FXML file 'Screen_Confirm_Remove.fxml'.";
		assert RemoveEmployee_Pane != null : "fx:id=\"RemoveEmployee_Pane\" was not injected: check your FXML file 'Screen_Confirm_Remove.fxml'.";

	}
}
