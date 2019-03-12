/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Primary_Pane"
    private AnchorPane Primary_Pane; // Value injected by FXMLLoader

    @FXML // fx:id="Password_Field"
    private TextField Password_Field; // Value injected by FXMLLoader

    @FXML // fx:id="Username_Field"
    private TextField Username_Field; // Value injected by FXMLLoader

    @FXML // fx:id="Quit_Button"
    private Button Quit_Button; // Value injected by FXMLLoader

    @FXML // fx:id="Log_In_Button"
    private Button Log_In_Button; // Value injected by FXMLLoader

    @FXML // fx:id="Label_U"
    private Label Label_U; // Value injected by FXMLLoader

    @FXML // fx:id="Label_P"
    private Label Label_P; // Value injected by FXMLLoader

    @FXML // fx:id="Lable_PLI"
    private Label Lable_PLI; // Value injected by FXMLLoader

    @FXML
    void program_login(ActionEvent event) throws IOException {
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("/Screen2.fxml"));
    	Primary_Pane.getChildren().setAll(pane);
    	

    }

    @FXML
    void program_quit(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Primary_Pane != null : "fx:id=\"Primary_Pane\" was not injected: check your FXML file 'Login.fxml'.";
        assert Password_Field != null : "fx:id=\"Password_Field\" was not injected: check your FXML file 'Login.fxml'.";
        assert Username_Field != null : "fx:id=\"Username_Field\" was not injected: check your FXML file 'Login.fxml'.";
        assert Quit_Button != null : "fx:id=\"Quit_Button\" was not injected: check your FXML file 'Login.fxml'.";
        assert Log_In_Button != null : "fx:id=\"Log_In_Button\" was not injected: check your FXML file 'Login.fxml'.";
        assert Label_U != null : "fx:id=\"Label_U\" was not injected: check your FXML file 'Login.fxml'.";
        assert Label_P != null : "fx:id=\"Label_P\" was not injected: check your FXML file 'Login.fxml'.";
        assert Lable_PLI != null : "fx:id=\"Lable_PLI\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
