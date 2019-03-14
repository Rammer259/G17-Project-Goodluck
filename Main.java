

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * This class handles, in tandem with Controller.class handles all gui functions
 */
public class Main extends Application{
	/*
	 * Set up the stage  by loading in resources from an fxml file in the same folder
	 * stops stage from being resized, sets title & scene, then presents the stage
	 * @param stage
	 * @throws Exception
	 *
	 */
	public void start(Stage stage)throws Exception{
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("/Login.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Employee Management System");
		stage.setResizable(false);
		stage.show();
	}
	/*
	 * Launches the GUI.
	 */
	
	public static void main(String[] args) {
		launch(args);
	}

}
